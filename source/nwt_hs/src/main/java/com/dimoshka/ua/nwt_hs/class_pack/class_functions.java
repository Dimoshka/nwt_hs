/*
 * Copyright (c) 2013.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;

import com.bugsense.trace.BugSenseHandler;
import com.dimoshka.ua.nwt_hs.R;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class class_functions {
    public SharedPreferences prefs;

    public boolean isNetworkAvailable(Activity activity) {
        try {
            ConnectivityManager cm = (ConnectivityManager) activity
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }

        } catch (Exception e) {
            Log.e("JWP_" + getClass().getName(), e.toString());
        }
        return false;
    }

    public boolean ExternalStorageState() {
        try {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                return true;
            } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                return false;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String get_dir_app(Context context) {
        String dir = Environment.getExternalStorageDirectory() + "/"
                + context.getResources().getString(R.string.app_dir);
        File Directory = new File(dir);
        if (!Directory.isDirectory()) {
            Directory.mkdirs();
        }
        return dir;
    }

    @SuppressLint("DefaultLocale")
    public String getMonth(int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.getDefault());
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(Calendar.MONTH, month);
        String m = sdf.format(localCalendar.getTime());
        m = m.replaceFirst(m.substring(0, 1),
                m.substring(0, 1).toUpperCase(Locale.getDefault()));
        return m;
    }

    public Cursor get_language(SQLiteDatabase database, Integer id,
                               Activity activity) {
        Cursor cursor;
        if (id == 0) {
            cursor = database.rawQuery("SELECT * from languages where iso_code='"
                    + Locale.getDefault().getLanguage() + "'", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                prefs = PreferenceManager.getDefaultSharedPreferences(activity);
                prefs.edit()
                        .putString("language",
                                cursor.getString(cursor.getColumnIndex("_id")))
                        .commit();
            }
        } else {
            cursor = database.rawQuery("SELECT * from languages where _id='" + id
                    + "'", null);
        }
        return cursor;
    }

    public String get_language_code(Activity activity, SQLiteDatabase database, int id) {
        String code_lng = "E";
        Cursor cursor = get_language(database, id, activity);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            code_lng = cursor.getString(cursor.getColumnIndex("code"));
        }
        return code_lng;
    }

    public void update_file_isn(SQLiteDatabase database, String name,
                                Integer file) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("file", file.toString());
        database.update("files", initialValues, "name=?", new String[]{name});
    }

    public String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }

    public void send_bug_report(Context context, Exception ex,
                                String class_name, Integer num_row) {
        Log.e(context.getString(R.string.app_name) + " - error " + class_name,
                ex.toString() + " - " + num_row);
        BugSenseHandler.addCrashExtraData("class_name", class_name.toString());
        BugSenseHandler.addCrashExtraData("num_row", num_row.toString());
        BugSenseHandler.sendException(ex);
    }

    public boolean load_img(Activity context, String dir, String name, String link_img) {
        try {
            URL url = new URL(link_img);
            File file = new File(dir, name + ".jpg");
            URLConnection ucon = url.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(
                    is);
            ByteArrayBuffer baf = new ByteArrayBuffer(
                    5000);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }

            FileOutputStream fos = new FileOutputStream(
                    file);
            fos.write(baf.toByteArray());
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            send_bug_report(context, e, getClass().getName(), 148);
            return false;
        }
    }

}
