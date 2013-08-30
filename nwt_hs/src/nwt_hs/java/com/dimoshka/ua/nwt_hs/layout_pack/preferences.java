/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dimoshka.ua.nwt_hs.layout_pack;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.util.Log;

import com.dimoshka.ua.nwt_hs.R;
import com.dimoshka.ua.nwt_hs.class_pack.class_sqlite;

public class preferences extends PreferenceActivity {

    private static SQLiteDatabase database;
    private static class_sqlite dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbOpenHelper = new class_sqlite(this);
        database = dbOpenHelper.openDataBase();
        setPreferenceScreen(createPreferenceHierarchy());
    }

    private PreferenceScreen createPreferenceHierarchy() {
        try {

            PreferenceScreen root = getPreferenceManager().createPreferenceScreen(this);
            PreferenceCategory dialogBasedPrefCat = new PreferenceCategory(this);
            dialogBasedPrefCat.setTitle(R.string.intetface);
            root.addPreference(dialogBasedPrefCat);

            Cursor c = database.rawQuery("SELECT * from languages order by `name_english`", null);
            int count = c.getCount();
            CharSequence[] entries = new CharSequence[count];
            CharSequence[] entryValues = new CharSequence[count];

            c.moveToFirst();
            for (int i = 0; i < count; i++) {
                entries[i] = c.getString(c.getColumnIndexOrThrow("name"));
                entryValues[i] = c.getString(c.getColumnIndexOrThrow("_id"));
                c.moveToNext();
            }
            c.close();

            ListPreference list_p = new ListPreference(this);
            list_p.setEntries(entries);
            list_p.setEntryValues(entryValues);
            list_p.setDefaultValue(1);
            list_p.setDialogTitle(R.string.language);
            list_p.setKey("language");
            list_p.setTitle(R.string.language);
            list_p.setSummary(R.string.language_summary);
            dialogBasedPrefCat.addPreference(list_p);


            dialogBasedPrefCat = new PreferenceCategory(this);
            dialogBasedPrefCat.setTitle(R.string.management);
            root.addPreference(dialogBasedPrefCat);
            CheckBoxPreference checkbox_p = new CheckBoxPreference(this);
            checkbox_p.setDefaultValue(true);
            checkbox_p.setKey("analytics");
            checkbox_p.setTitle(R.string.analytics);
            checkbox_p.setSummary(R.string.analytics_summary);
            dialogBasedPrefCat.addPreference(checkbox_p);

            return root;

        } catch (Exception e) {
            Log.e("Error", e.toString());
            return null;
        }
    }
}
