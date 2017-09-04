package com.asad.taleembazar.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asad.taleembazar.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by rAnA aRsI on 9/3/2017.
 */

public class SubmitAddPicturesUpload {




        Bitmap bitmap1,bitmap2,bitmap3,bitmap4;

        boolean check = true;


        String ConvertImage1,ConvertImage2,ConvertImage3,ConvertImage4;

        String email;
String title;
    String desc;
    String loc,cid1;
    String cat;
    String price;
String usernum;
        Context cnt;

        String ImageName = "image_name";
    String addtype;

        String ImagePath = "image_path";

        String ServerUploadPath = "http://taleembazaar.com/submitadd.php";

        public SubmitAddPicturesUpload(Context ctx, String email,String usernum,String title,String desc,String loc,String cat,String price, Bitmap bm1,Bitmap bm2,Bitmap bm3,Bitmap bm4)
        {
            this.email=email;
            this.bitmap1=bm1;
            this.bitmap2=bm2;
            this.bitmap3=bm3;
            this.bitmap4=bm4;
            this.title=title;
            this.loc=String.valueOf(loc.charAt(0));
            this.cat=cat.substring(1,2);
this.cid1=String.valueOf(cat.charAt(0));
            this.addtype=cat.substring(2,cat.length());
            this.desc=desc;
            this.price=price;
            this.usernum=usernum;
            this.cnt=ctx;
            ImageUploadToServerFunction();


        }


        public void ImageUploadToServerFunction() {

            ByteArrayOutputStream byteArrayOutputStreamObject1,byteArrayOutputStreamObject2,byteArrayOutputStreamObject3,byteArrayOutputStreamObject4;

            byteArrayOutputStreamObject1 = new ByteArrayOutputStream();
            byteArrayOutputStreamObject2 = new ByteArrayOutputStream();
            byteArrayOutputStreamObject3 = new ByteArrayOutputStream();
            byteArrayOutputStreamObject4 = new ByteArrayOutputStream();

            bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject1);
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject2);
            bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject3);
            bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject4);

            byte[] byteArrayVar1 = byteArrayOutputStreamObject1.toByteArray();

            ConvertImage1  = Base64.encodeToString(byteArrayVar1, Base64.DEFAULT);
            byte[] byteArrayVar2 = byteArrayOutputStreamObject2.toByteArray();

            ConvertImage2  = Base64.encodeToString(byteArrayVar2, Base64.DEFAULT);
            byte[] byteArrayVar3 = byteArrayOutputStreamObject3.toByteArray();

            ConvertImage3  = Base64.encodeToString(byteArrayVar3, Base64.DEFAULT);
            byte[] byteArrayVar4 = byteArrayOutputStreamObject4.toByteArray();

            ConvertImage4  = Base64.encodeToString(byteArrayVar4, Base64.DEFAULT);


            class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {

                @Override
                protected void onPreExecute() {

                    super.onPreExecute();


                }

                @Override
                protected void onPostExecute(String string1) {

                    super.onPostExecute(string1);

                    // Dismiss the progress dialog after done uploading.


                    // Printing uploading success message coming from server on android app.
                    Toast.makeText(cnt, string1, Toast.LENGTH_LONG).show();
                    Log.d("error",string1);

                    // Setting image as transparent after done uploading.



                }

                @Override
                protected String doInBackground(Void... params) {

                    ImageProcessClass imageProcessClass = new ImageProcessClass();

                    HashMap<String, String> HashMapParams = new HashMap<String, String>();

                    HashMapParams.put(ImageName, email);

                    HashMapParams.put("image1", ConvertImage1);
                    HashMapParams.put("image2", ConvertImage2);
                    HashMapParams.put("image3", ConvertImage3);
                    HashMapParams.put("image4", ConvertImage4);

                    String FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);

                    return FinalData;
                }
            }
            AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

            AsyncTaskUploadClassOBJ.execute();
        }

        public class ImageProcessClass {

            public String ImageHttpRequest(String requestURL, HashMap<String, String> PData) {

                StringBuilder stringBuilder = new StringBuilder();

                try {

                    URL url;
                    HttpURLConnection httpURLConnectionObject;
                    OutputStream OutPutStream;
                    BufferedWriter bufferedWriterObject;
                    BufferedReader bufferedReaderObject;
                    int RC;

                    url = new URL(requestURL);

                    httpURLConnectionObject = (HttpURLConnection) url.openConnection();

                    httpURLConnectionObject.setReadTimeout(19000);

                    httpURLConnectionObject.setConnectTimeout(19000);

                    httpURLConnectionObject.setRequestMethod("POST");

                    httpURLConnectionObject.setDoInput(true);

                    httpURLConnectionObject.setDoOutput(true);

                    OutPutStream = httpURLConnectionObject.getOutputStream();

                    bufferedWriterObject = new BufferedWriter(

                            new OutputStreamWriter(OutPutStream, "UTF-8"));

                    bufferedWriterObject.write(bufferedWriterDataFN(PData));

                    bufferedWriterObject.flush();

                    bufferedWriterObject.close();

                    OutPutStream.close();

                    RC = httpURLConnectionObject.getResponseCode();

                    if (RC == HttpsURLConnection.HTTP_OK) {

                        bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                        stringBuilder = new StringBuilder();

                        String RC2;

                        while ((RC2 = bufferedReaderObject.readLine()) != null) {

                            stringBuilder.append(RC2);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return stringBuilder.toString();
            }

            private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {
                String data="";


                data = URLEncoder.encode("image1", "UTF-8") + "=" + URLEncoder.encode(ConvertImage1, "UTF-8") + "&" +
                        URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")+ "&" +
                        URLEncoder.encode("image2", "UTF-8") + "=" + URLEncoder.encode(ConvertImage2, "UTF-8")+ "&" +
                        URLEncoder.encode("image3", "UTF-8") + "=" + URLEncoder.encode(ConvertImage3, "UTF-8")+ "&" +
                        URLEncoder.encode("image4", "UTF-8") + "=" + URLEncoder.encode(ConvertImage4, "UTF-8")+ "&" +
                        URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8")+ "&" +
                        URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(desc, "UTF-8")+ "&" +
                        URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8")+ "&" +
                        URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(loc, "UTF-8")+ "&" +
                        URLEncoder.encode("categorie", "UTF-8") + "=" + URLEncoder.encode(cid1, "UTF-8")+ "&" +
                        URLEncoder.encode("addtype", "UTF-8") + "=" + URLEncoder.encode(addtype, "UTF-8")+ "&" +
                        URLEncoder.encode("usernum", "UTF-8") + "=" + URLEncoder.encode(usernum, "UTF-8");


                return data;
            }

        }
    }


