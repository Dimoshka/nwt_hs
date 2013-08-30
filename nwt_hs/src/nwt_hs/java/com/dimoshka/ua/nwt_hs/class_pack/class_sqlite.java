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
            database.execSQL("CREATE TABLE languages (_id INTEGER PRIMARY KEY AUTOINCREMENT, code VARCHAR(6) NOT NULL UNIQUE, iso_code VARCHAR(6) NOT NULL UNIQUE, name_english VARCHAR(20), name VARCHAR(20));");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (1, 'E', 'en', 'English', 'English');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (2, 'X', 'de', 'German', 'Deutsch');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (3, 'I', 'it', 'Italian', 'Italiano');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (4, 'P', 'pl', 'Polish', 'Polski');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (5, 'T', 'pt', 'Portugues', 'Português');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (6, 'S', 'es', 'Spanish', 'Español');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (7, 'CHS', 'zh-CN', 'Chinese (Simplified)', '汉语(简化字)');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (8, 'CH', 'zh-TW', 'Chinese (Traditional)', '漢語(繁體字)');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (9, 'KO', 'ko', 'Korean', '한국어');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (10, 'TG', 'tl', 'Tagalog', 'Tagalog');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (11, 'G', 'el', 'Greek', 'Ελληνική');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (12, 'Z', 'sv', 'Swedish', 'Svenska');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (13, 'U', 'ru', 'Russian', 'Русский');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (14, 'F', 'fr', 'French', 'Français');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (15, 'FI', 'fi', 'Finnish', 'Suomi');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (16, 'N', 'no', 'Norwegian', 'Norsk');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (17, 'B', 'cs', 'Czech', 'Česky');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (18, 'V', 'sk', 'Slovak', 'Slovenčina');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (19, 'H', 'hu', 'Hungarian', 'Magyar');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (20, 'D', 'da', 'Danish', 'Dansk');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (21, 'O', 'nl', 'Nederlands', 'Dutch');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (22, 'SB', 'sr', 'Serbian', 'Српски');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (23, 'CV', 'ceb', 'Cebuano', 'Cebuano');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (24, 'M', 'ro', 'Romanian', 'Română');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (25, 'ZU', 'zu', 'Zulu', 'isiZulu');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (26, 'IN', 'in', 'Indonesian', 'Bahasa Indonesia');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (27, 'AF', 'af', 'Afrikaans', 'Afrikaans');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (28, 'SV', 'sl', 'Slovenian', 'Slovenski');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (29, 'REA', 'hy', 'Armenian', 'Հայերէն');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (30, 'TWK', 'ak', 'Twi (Akuapem)', 'Twi (Akuapem)');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (31, 'TWS', 'tw', 'Twi (Asante)', 'Twi (Asante)');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (32, 'K', 'uk', 'Ukrainian', 'Українська');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (33, 'BL', 'bg', 'Bulgarian', 'български');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (34, 'ST', 'et', 'Estonian', 'Eesti');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (35, 'EW', 'ee', 'Ewe', 'Ewe');");
            database.execSQL("INSERT INTO [languages] ([_id], [code], [iso_code], [name_english], [name]) VALUES (36, 'L', 'lt', 'Lithuanian', 'Lietuvių');");


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