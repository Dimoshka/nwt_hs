/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dimoshka.ua.nwt_hs.layout_pack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

import com.bugsense.trace.BugSenseHandler;
import com.dimoshka.ua.nwt_hs.R;
import com.dimoshka.ua.nwt_hs.class_pack.class_downloads_files;
import com.dimoshka.ua.nwt_hs.class_pack.class_linck;
import com.dimoshka.ua.nwt_hs.class_pack.class_sqlite;
import com.google.analytics.tracking.android.EasyTracker;


public class main extends Activity {

    public static SharedPreferences prefs;
    private Integer id_ln;
    private static SQLiteDatabase database;
    private static class_sqlite dbOpenHelper;

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

        start_download();

        //} else {

        //}
    }

    private void language_select() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.language_summary);
        builder.setItems(getResources().getStringArray(R.array.language_arr), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String[] lang_arr_val = getResources().getStringArray(R.array.language_arr_value);
                prefs.edit().putString("language", lang_arr_val[item]).commit();
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
            }
        }
    };




    private void start_download() {
        class_linck lnk = new class_linck(this, database);
        class_downloads_files df = new class_downloads_files(this, lnk.get_bible_url(Integer.parseInt(prefs.getString("language", "1"))));
        df.download_start();
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
