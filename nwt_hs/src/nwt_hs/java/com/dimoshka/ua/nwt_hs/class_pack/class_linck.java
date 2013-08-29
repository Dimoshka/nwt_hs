/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class class_linck {

    static final String URL_Bible = "http://www.jw.org/apps/E_TRGCHlZRQVNYVrXF?fileformat=PDF&output=html&pub=nwt&langwritten=%s";
    // http://www.jw.org/download/?fileformat=PDF&output=html&pub=nwt&langwritten=U
    // http://www.jw.org/apps/E_TRGCHlZRQVNYVrXF?fileformat=PDF&output=html&pub=nwt&langwritten=%s

    private SQLiteDatabase database;
    private class_functions funct = new class_functions();
    private Activity activity;
    private Integer id_lng = 1;
    private String code_lng = "E";

    public class_linck(Activity activity, SQLiteDatabase database) {
        this.activity = activity;
        this.database = database;
    }

    public Integer get_language(int id) {
        Cursor cursor = funct.get_language(database, id, activity);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            id_lng = cursor.getInt(cursor.getColumnIndex("_id"));
            code_lng = cursor.getString(cursor.getColumnIndex("code"));
        } else {
            id_lng = 1;
            code_lng = "E";
        }
        return id_lng;
    }

    public String get_bible_url(int id_lang) {
        get_language(id_lang);
        return String.format(URL_Bible, code_lng);
    }


}
