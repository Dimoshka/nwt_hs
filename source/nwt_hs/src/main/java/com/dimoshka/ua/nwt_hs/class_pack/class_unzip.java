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
import android.os.Handler;

import com.dimoshka.ua.nwt_hs.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by designers on 29.08.13.
 */
public class class_unzip {

    private ProgressDialog mProgressDialog;
    private Activity context;
    Handler hnd;

    public class_unzip(Activity context, Handler hnd) {
        this.context = context;
        this.hnd = hnd;
    }

    public void unzip(String location, String zipFile) {
        new asynctask_unzip_files(location, zipFile).execute();
    }

    protected Dialog showDialog(Integer max) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(R.string.unziping));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(max);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        return mProgressDialog;
    }


    class asynctask_unzip_files extends AsyncTask<Void, Integer, Boolean> {
        String strBinaryPath;
        String strExtractPath;


        public asynctask_unzip_files(String strBinaryPath, String strExtractPath) {
            this.strBinaryPath = strBinaryPath;
            this.strExtractPath = strExtractPath;
        }

        @Override
        protected void onPreExecute() {
            try {
                super.onPreExecute();
                File f = new File(strBinaryPath);
                if (f.exists()) {
                    ZipFile zp = new ZipFile(f);
                    Integer files = zp.size();
                    zp.close();
                    showDialog(files);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void dirChecker(String location, String dir) {
            File f = new File(location + dir);
            if (!f.isDirectory()) {
                f.mkdirs();
            }
        }

        @Override
        protected Boolean doInBackground(Void... f_url) {
            try {
                Integer per = 0;
                ZipFile zipInFile = null;
                try {
                    if (strExtractPath != null) {
                        zipInFile = new ZipFile(strBinaryPath);
                        for (Enumeration<? extends ZipEntry> entries = zipInFile.entries(); entries.hasMoreElements(); ) {
                            ZipEntry zipMediaEntry = entries.nextElement();
                            if (zipMediaEntry.isDirectory()) {
                                File mediaDir = new File(strExtractPath + zipMediaEntry.getName());
                                mediaDir.mkdirs();
                            } else {
                                BufferedInputStream bisMediaFile = null;
                                FileOutputStream fosMediaFile = null;
                                BufferedOutputStream bosMediaFile = null;
                                try {
                                    String strFileName = strExtractPath + zipMediaEntry.getName();
                                    File uncompressDir = new File(strFileName).getParentFile();
                                    uncompressDir.mkdirs();

                                    bisMediaFile = new BufferedInputStream(zipInFile.getInputStream(zipMediaEntry));
                                    fosMediaFile = new FileOutputStream(strFileName);
                                    bosMediaFile = new BufferedOutputStream(fosMediaFile);

                                    int counter;
                                    byte data[] = new byte[2048];

                                    while ((counter = bisMediaFile.read(data, 0, 2048)) != -1) {
                                        bosMediaFile.write(data, 0, counter);
                                    }

                                    per++;
                                    publishProgress(per);

                                } catch (Exception ex) {
                                    throw ex;
                                } finally {
                                    if (bosMediaFile != null) {
                                        bosMediaFile.flush();
                                        bosMediaFile.close();
                                    }
                                    if (bisMediaFile != null)
                                        bisMediaFile.close();
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    throw ex;
                } finally {
                    if (zipInFile != null)
                        zipInFile.close();
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }

        protected void onProgressUpdate(Integer... progress) {
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            mProgressDialog.dismiss();
            hnd.sendEmptyMessage(3);
        }

    }

}
