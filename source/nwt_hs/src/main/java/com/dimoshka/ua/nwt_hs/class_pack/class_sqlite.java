/*
 * Copyright (c) 2013.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dimoshka.ua.nwt_hs.R;

public class class_sqlite extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    private class_functions funct = new class_functions();
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


            // -- Table: structure_book
            database.execSQL("CREATE TABLE structure_book (_id INTEGER PRIMARY KEY AUTOINCREMENT, name INTEGER NOT NULL);");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (1, 'GE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (2, 'EX');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (3, 'LE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (4, 'NU');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (5, 'DE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (6, 'JOS');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (7, 'JG');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (8, 'RU');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (9, '1SA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (10, '2SA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (11, '1KI');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (12, '2KI');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (13, '1CH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (14, '2CH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (15, 'EZR');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (16, 'NE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (17, 'ES');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (18, 'JOB');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (19, 'PS');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (20, 'PR');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (21, 'EC');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (22, 'CA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (23, 'ISA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (24, 'JER');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (25, 'LA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (26, 'EZE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (27, 'DA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (28, 'HO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (29, 'JOE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (30, 'AM');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (31, 'OB');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (32, 'JON');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (33, 'MIC');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (34, 'NA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (35, 'HAB');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (36, 'ZEP');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (37, 'HAG');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (38, 'ZEC');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (39, 'MAL');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (40, 'MT');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (41, 'MR');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (42, 'LU');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (43, 'JOH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (44, 'AC');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (45, 'RO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (46, '1CO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (47, '2CO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (48, 'GA');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (49, 'EPH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (50, 'PHP');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (51, 'COL');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (52, '1TH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (53, '2TH');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (54, '1TI');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (55, '2TI');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (56, 'TIT');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (57, 'PHM');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (58, 'HEB');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (59, 'JAS');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (60, '1PE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (61, '2PE');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (62, '1JO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (63, '2JO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (64, '3JO');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (65, 'JUD');");
            database.execSQL("INSERT INTO [structure_book] ([_id], [name]) VALUES (66, 'RE');");
            // -- Table: books
            database.execSQL("CREATE TABLE books (_id INTEGER PRIMARY KEY AUTOINCREMENT, language INTEGER NOT NULL, name VARCHAR(20) NOT NULL, name_shot VARCHAR(6) NOT NULL);");
            // -- Table: chapters
            database.execSQL("CREATE TABLE chapters (_id INTEGER PRIMARY KEY AUTOINCREMENT, book INTEGER NOT NULL, name VARCHAR(5) NOT NULL);");
            // -- Table: text
            database.execSQL("CREATE TABLE text (_id INTEGER PRIMARY KEY AUTOINCREMENT, chapter INTEGER NOT NULL, name VARCHAR(5) NOT NULL, link TEXT NOT NULL);");
            // -- Table: content
            database.execSQL("CREATE TABLE content (_id INTEGER PRIMARY KEY AUTOINCREMENT, chapter INTEGER NOT NULL, body TEXT NOT NULL);");
            // -- Table: bookmark
            database.execSQL("CREATE TABLE bookmark (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(64) NOT NULL, book INTEGER NOT NULL, chapter INTEGER, text INTEGER);");


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