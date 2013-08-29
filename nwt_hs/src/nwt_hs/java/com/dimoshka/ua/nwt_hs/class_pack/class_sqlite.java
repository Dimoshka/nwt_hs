/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dimoshka.ua.nwt_hs.R;

public class class_sqlite extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public class_functions funct = new class_functions();
    private Context context;

    public class_sqlite(Context context) {
        super(context, context.getString(R.string.db_name), null, Integer
                .valueOf(context.getString(R.string.db_version)));
        this.context = context;
        database = this.getWritableDatabase();
    }

    public SQLiteDatabase openDataBase() {
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i(getClass().getName(), "Start create SQLITE");
        try {
            // -- Table: language
            database.execSQL("CREATE TABLE language (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(64) NOT NULL UNIQUE, code VARCHAR(4) NOT NULL UNIQUE, code_an VARCHAR(6) NOT NULL UNIQUE);");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (1, 'English', 'E', 'en');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (2, 'French', 'F', 'fr');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (3, 'Русский', 'U', 'ru');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (4, 'Українська', 'K', 'uk');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (5, 'Deutsch', 'X', 'de');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (6, 'Spanish', 'S', 'es');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (7, '漢語繁體字', 'CH', 'zh');");
            database.execSQL("INSERT INTO [language] ([_id], [name], [code], [code_an]) VALUES (8, '汉语简化字', 'CHS', 'zhc');");

        } catch (Exception ex) {
            funct.send_bug_report(context, ex, getClass().getName(), 63);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        Log.i("JWP" + getClass().getName(), "Start update SQLITE");
        switch (oldVersion) {
            case 1:
                database.execSQL("DROP TABLE IF EXISTS language");
                onCreate(database);
                break;
            default:
                database.execSQL("DROP TABLE IF EXISTS language");
                onCreate(database);
                break;
        }

    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }
}