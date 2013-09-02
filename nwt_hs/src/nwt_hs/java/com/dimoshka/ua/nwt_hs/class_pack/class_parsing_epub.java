/*
 * Copyright (c) 2013.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by designers on 30.08.13.
 */
public class class_parsing_epub {

    private class_functions funct = new class_functions();
    private Activity activity;
    private SQLiteDatabase database;
    private String code_lng = "E";


//05_BI12_.CON.xhtml - список книг


    public class_parsing_epub(Activity activity, SQLiteDatabase database) {
        this.activity = activity;
        this.database = database;
    }


    public void start(int id_lang) {
        String path = funct.get_dir_app(activity);
        code_lng = funct.get_language_code(activity, database, id_lang);
        path+="/" + code_lng + "OEBPS/";

    }


}
