/*
 * Copyright (c) 2013.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class class_linck {

    static final String URL_Bible = "http://www.jw.org/apps/E_TRGCHlZRQVNYVrXF?fileformat=EPUB&output=html&pub=nwt&langwritten=%s";
    // http://www.jw.org/download/?fileformat=PDF&output=html&pub=nwt&langwritten=U
    // http://www.jw.org/apps/E_TRGCHlZRQVNYVrXF?fileformat=EPUB&output=html&pub=nwt&langwritten=E

    private SQLiteDatabase database;
    private class_functions funct = new class_functions();
    private Activity activity;
    private String code_lng = "E";

    public class_linck(Activity activity, SQLiteDatabase database) {
        this.activity = activity;
        this.database = database;
    }

    public String get_bible_url(int id_lang) {
        code_lng = funct.get_language_code(activity, database, id_lang);
        return String.format(URL_Bible, code_lng);
    }


}
