
/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dimoshka.ua.nwt_hs.class_pack;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.dimoshka.ua.nwt_hs.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class class_downloads_files {
    private Activity context;
    private String url = "";
    private class_functions funct = new class_functions();
    private asynctask_downloads_files adf;

    public class_downloads_files(Activity context, String url) {
        this.context = context;
        this.url = url;
    }

    public boolean download_start() {
        if (funct.isNetworkAvailable(context)) {
            if (funct.ExternalStorageState()) {
                try {
                    adf = new asynctask_downloads_files();
                    adf.execute(url);
                    return adf.get();
                } catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
                    return false;
                }
            } else {
                Toast toast = Toast.makeText(context, R.string.no_sdcard, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return false;
            }
        } else

        {
            Toast toast = Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
    }

    class asynctask_downloads_files extends AsyncTask<String, String, Boolean> {
        private ProgressDialog pDialog;

        protected Dialog showDialog() {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(context.getString(R.string.downloading));
            pDialog.setIndeterminate(false);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setCancelable(true);
            pDialog.show();
            return pDialog;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog();
        }

        @Override
        protected Boolean doInBackground(String... f_url) {
            int count;
            try {
                String fileName="";
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                int lenghtOfFile = conection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream output = new FileOutputStream(funct.get_dir_app(context) + "/temp.zip");
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
                return true;
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
                return false;
            }
        }

        protected void onProgressUpdate(String... progress) {
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            pDialog.dismiss();
        }

    }
}