package com.asad.taleembazar.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.asad.taleembazar.CallBack;
import com.asad.taleembazar.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class SubmitAddActivity extends AppCompatActivity implements CallBack {
    private Toolbar mToolbar;
    private TextInputEditText title_TextInput;
    private TextInputEditText description_TextInput;
    private TextInputEditText price_TextInput;
    private ImageView[] imageviews=new ImageView[4];
    private ImageView currentimageview;
    private Button submitbutton;
    private Spinner selctcategory;
    private Spinner selectlocation;
    private Dialog dialog;
    private String title;//this is title
    private String description;//this is description
    private String category;//this is category
    private String location;//tis is location
    private String price;//this is price
    private Bitmap[] images=new Bitmap[4];//here's 4 images
    //use these variables for uploading the data
    private ArrayList<String> arraylistcategory=new ArrayList<String>();
    private  ArrayList<String> arralistlocation=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitadd_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_submitadd);
        submitbutton=(Button)findViewById(R.id.button_submitadd);
        selctcategory=(Spinner)findViewById(R.id.selectcategory_submitadd);
        selectlocation=(Spinner)findViewById(R.id.selectlocation_submitadd);
        settingToolbar();
        intializearraylist();
        displaySpinnerCategory();
        displaySpinnerLocation();
        title_TextInput=(TextInputEditText)findViewById(R.id.titleedittxt_submitadd);
        description_TextInput=(TextInputEditText)findViewById(R.id.descrpitionedittxt_submitadd);
        price_TextInput=(TextInputEditText)findViewById(R.id.priceedittxt_submitadd);
        imageviews[0]=(ImageView)findViewById(R.id.first_imageview_submitadd);
        imageviews[1]=(ImageView)findViewById(R.id.second_imageview_submitadd);
        imageviews[2]=(ImageView)findViewById(R.id.third_imageview_submitadd);
        imageviews[3]=(ImageView)findViewById(R.id.forth_imageview_submitadd);
        imageviews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentimageview=imageviews[0];
                setDialog();
            }
        });
        imageviews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentimageview=imageviews[1];
                setDialog();
            }
        });
        imageviews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentimageview=imageviews[2];
                setDialog();
            }
        });
        imageviews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentimageview=imageviews[3];
                setDialog();
            }
        });
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAdd();
            }
        });


    }

    private void submitAdd() {

        title=title_TextInput.getText().toString();
        description=description_TextInput.getText().toString();
        price=price_TextInput.getText().toString();
        if(title.equals("")||description.equals("")||price.equals("")||
                category.equals("")||location.equals(""))
        {
            Snackbar.make(submitbutton,"Please specify all the fields",Snackbar.LENGTH_SHORT).show();

        }
        else
        {
            for (int i=0;i<imageviews.length;i++)
            if(imageviews[i].getDrawable().getConstantState().equals(getResources().
                    getDrawable(R.drawable.uploadprofile).getConstantState()))
            {
                Snackbar.make(submitbutton,"Please select all the images",Snackbar.LENGTH_SHORT).show();
                return;
            }
            else
            {
                for(int j=0;j<imageviews.length;j++)
                {
                    images[j]=((BitmapDrawable)imageviews[j].getDrawable()).getBitmap();
                }
            }
        }
    }

    private void displaySpinnerLocation() {
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item2,arralistlocation){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item2);
        selectlocation.setAdapter(spinnerArrayAdapter);

        selectlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                  location=selectedItemText;
                  //  Toast.makeText(getApplicationContext(),selectedItemText,Toast.LENGTH_LONG).show();
                    //this is
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void displaySpinnerCategory() {
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,arraylistcategory){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        selctcategory.setAdapter(spinnerArrayAdapter);
        selctcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                   category=selectedItemText;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void intializearraylist() {
       categoriesfile obj=new categoriesfile();
        obj.execute();
       locationfile obj1=new locationfile();
        obj1.setCalback(this);
        obj1.execute();
    }

    private void settingToolbar() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Submit Add");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setDialog()
    {
       dialog = new Dialog(SubmitAddActivity.this);

       // dialog.requestWindowFeature(Window.F);

        dialog.setContentView(R.layout.customdialog_pickimage);
        dialog.setTitle("Take Image");

       // dialog.getWindow().setBackgroundDrawable(
        //        new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView cameraselect=(TextView)dialog.findViewById(R.id.cameratxt);
        TextView gallery=(TextView)dialog.findViewById(R.id.gallerytxt);
        Toolbar toolbarcustom=(Toolbar)dialog.findViewById(R.id.toolbar_dialog);
        setSupportActionBar(toolbarcustom);
        getSupportActionBar().setTitle("Take Image");
        cameraselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromCamera();
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallery();
            }
        });
        dialog.show();
    }

    private void selectImageFromGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);
        dialog.cancel();

    }

    private void selectImageFromCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);
        dialog.cancel();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Toast.makeText(getApplicationContext(),"Camera",Toast.LENGTH_SHORT).show();
                    Uri selectedImage = imageReturnedIntent.getData();
                    currentimageview.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    currentimageview.setImageURI(selectedImage);
                }
                break;
        }
    }

    @Override
    public void getValue(Boolean bol) {
        if (bol)
        {
            displaySpinnerLocation();
        displaySpinnerCategory();
    }
    }

    private class categoriesfile extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/getcategories.php";



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String m=sb.toString();

                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            String cid="";
            String categories="";
                try {
                    JSONObject obj1 = new JSONObject(s);
                    JSONArray contacts = obj1.getJSONArray("categories_main");
                    arraylistcategory.add("Category");
                    int count = 0;
                    while (count < contacts.length()) {
                        JSONObject jo = contacts.getJSONObject(count);
                        cid = jo.getString("cid");
                        categories = jo.getString("categories");
                        arraylistcategory.add(cid+" "+categories);
                        count++;

                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Unable to Parse Data",Toast.LENGTH_LONG).show();
                }


            }

        }
    private class locationfile extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/getlocation.php";
        CallBack callBack;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String m=sb.toString();

                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            String locid="";
            String location="";
            try {
                JSONObject obj1 = new JSONObject(s);
                JSONArray contacts = obj1.getJSONArray("location_main");
                int count = 0;
                arralistlocation.add("Location");
                while (count < contacts.length()) {
                    JSONObject jo = contacts.getJSONObject(count);
                    locid = jo.getString("locid");
                    location = jo.getString("location");
                    arralistlocation.add(locid+" "+location);
                    count++;

                }
                callBack.getValue(true);

            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Unable to Parse Data",Toast.LENGTH_LONG).show();
            }


        }
        public void setCalback(CallBack calbacks)
        {

            callBack=calbacks;
        }

    }


}

