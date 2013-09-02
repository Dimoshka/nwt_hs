
/*
 * Copyright (c) 2013.
 */

package com.dimoshka.ua.nwt_hs.layout_pack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bugsense.trace.BugSenseHandler;
import com.dimoshka.ua.nwt_hs.R;
import com.dimoshka.ua.nwt_hs.class_pack.class_downloads_files;
import com.dimoshka.ua.nwt_hs.class_pack.class_functions;
import com.dimoshka.ua.nwt_hs.class_pack.class_linck;
import com.dimoshka.ua.nwt_hs.class_pack.class_sqlite;
import com.dimoshka.ua.nwt_hs.class_pack.class_unzip;
import com.google.analytics.tracking.android.EasyTracker;


public class main extends Activity {

    public static SharedPreferences prefs;
    private static SQLiteDatabase database;
    private static class_sqlite dbOpenHelper;
    private class_functions funct = new class_functions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("analytics", true)) {
            BugSenseHandler.initAndStartSession(this, "7434677f");
            BugSenseHandler.setLogging(100);
        }
        setContentView(R.layout.main);

        dbOpenHelper = new class_sqlite(this);
        database = dbOpenHelper.openDataBase();

        boolean firstrun = prefs.getBoolean("first_run", true);
        //if (firstrun) {
        //language_select();
        //} else {

        //}
    }

    private void language_select() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.language_summary);

        Cursor c = database.rawQuery("SELECT * from languages order by `name_english`;", null);
        int count = c.getCount();
        final CharSequence[] entries = new CharSequence[count];
        final CharSequence[] entryValues = new CharSequence[count];

        c.moveToFirst();
        for (int i = 0; i < count; i++) {
            entries[i] = c.getString(c.getColumnIndexOrThrow("name"));
            entryValues[i] = c.getString(c.getColumnIndexOrThrow("_id"));
            c.moveToNext();
        }
        c.close();
        builder.setItems(entries, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                prefs.edit().putString("language", entryValues[item].toString()).commit();
                prefs.edit().putBoolean("first_run", false).commit();
                dialog.dismiss();
                hnd.sendEmptyMessage(1);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    private final Handler hnd = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    start_download();
                    break;
                case 2:
                    start_parsing();
                    break;
                case 3:

                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item0:
                System.exit(0);
                break;
            case R.id.item1:
                Intent i = new Intent(this, preferences.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return false;
    }

    private void start_download() {
        class_linck lnk = new class_linck(this, database);
        class_downloads_files df = new class_downloads_files(this, lnk.get_bible_url(Integer.parseInt(prefs.getString("language", "1"))), hnd);
        df.download_start();
    }

    private void start_parsing() {
        class_unzip unzip = new class_unzip(this, hnd);
        String code_lng = funct.get_language_code(this, database, Integer.parseInt(prefs.getString("language", "1")));
        unzip.unzip(funct.get_dir_app(this) + "/temp.zip", funct.get_dir_app(this) + "/" + code_lng + "/");
    }

    @Override
    public void onStart() {
        super.onStart();
        if (prefs.getBoolean("analytics", true)) {
            EasyTracker.getInstance().activityStart(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (prefs.getBoolean("analytics", true)) {
            EasyTracker.getInstance().activityStop(this);
        }
    }
}
