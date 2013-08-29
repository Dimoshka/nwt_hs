
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
    private String url_link = "";
    private class_functions funct = new class_functions();

    private ProgressDialog mProgressDialog;

    public class_downloads_files(Activity context, String url) {
        this.context = context;
        this.url_link = url;
    }

    public void download_start() {
        if (funct.isNetworkAvailable(context)) {
            if (funct.ExternalStorageState()) {
                try {
                    new asynctask_downloads_files().execute();

                    // return adf.get();
                } catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
                    //return false;
                }
            } else {
                Toast toast = Toast.makeText(context, R.string.no_sdcard, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                // return false;
            }
        } else

        {
            Toast toast = Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            //return false;
        }
    }


    protected Dialog showDialog() {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(R.string.downloading));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        return mProgressDialog;
    }

    class asynctask_downloads_files extends AsyncTask<Void, String, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog();
        }

        @Override
        protected Boolean doInBackground(Void... f_url) {
            int count;
            try {
                String fileName = "";
                URL url = new URL(url_link);
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
            mProgressDialog.setProgress(Integer.parseInt(progress[0]));
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            mProgressDialog.dismiss();
        }

    }
}