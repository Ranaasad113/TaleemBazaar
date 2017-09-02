package com.asad.taleembazar.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdapterMyAccount;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

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

import de.hdodenhof.circleimageview.CircleImageView;
import com.asad.taleembazar.fragments.RegisterFragment;
import com.asad.taleembazar.serlization.MyAccountData;

public class MyAccountActivity extends AppCompatActivity implements RegisterFragment.Communication,com.asad.taleembazar.adpaters.callback {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerAdapterMyAccount mAdapter;
    private ArrayList<MyAccountData> mArrayList = new ArrayList<>();
    private static final int REQUEST_CAPTURE = 1;
    private CircleMenu mCircleMenu;
    private static final int REQUEST_GALLERY_CODE = 2;
    private RecyclerView.LayoutManager mLayoutManager;
    private String type;
    private String textFromDialog;
    EditText oldpass;
    EditText newpass;
    EditText cnfrmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.myaccount);
        mToolbar = (Toolbar) findViewById(R.id.toolbarmyaccount);
        mCircleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        setCircleMenu();
        settingToolbar();//Here's Toolbar of that Activity Set

    }

    private void settingToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse);
        collapsingToolbar.setTitle("Rana Asad");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white_color));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white_color));
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_for_myaccount);
        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mArrayList.add(new MyAccountData(R.drawable.changepassword_icon, "Change Password"));
        mArrayList.add(new MyAccountData(R.drawable.changephoneno_icon, "Change Mobile No"));
        mArrayList.add(new MyAccountData(0, "Sign Out"));
        mAdapter = new RecyclerAdapterMyAccount(mArrayList);
        mAdapter.setOnClick(this);
        mRecyclerView.setAdapter(mAdapter) ;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }





    public void accept(int j) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setProfileImage(requestCode, resultCode, data);
    }

    private void setCircleMenu() {//In this Method the Circle Menu is set
        mCircleMenu.setMainMenu(Color.TRANSPARENT, R.drawable.camera_icon_for_submitadds, R.drawable.camera_icon_for_submitadds);
        mCircleMenu.addSubMenu(Color.parseColor("#258CFF"), R.drawable.camera_icon_for_submitadds)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.image_gallery_icon);
        mCircleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

            @Override
            public void onMenuSelected(int index) {
        switch (index) {
            case 0:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAPTURE);
                break;
            case 1:
                Intent intent1 = new Intent();
                intent1.setType("image/*");
                intent1.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent1, "Select File"), REQUEST_GALLERY_CODE);
                break;

        }
                                                 }
        }

        );

        mCircleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {

            }

            @Override
            public void onMenuClosed() {

            }
        }
        );
    }

    private void setProfileImage(int requestCode, int resultCode, Intent data) {/*here's the Profile image is set
                                                                                     and this Function is called in onActivityResult Method*/
        CircleImageView image1 = (CircleImageView) findViewById(R.id.profile_image_my_account);
        if (requestCode == REQUEST_CAPTURE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap image = (Bitmap) bundle.get("data");
            image1.setImageBitmap(image);
        } else if (requestCode == REQUEST_GALLERY_CODE && resultCode == RESULT_OK) {
            Bitmap bm = null;
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image1.setImageBitmap(bm);
            PictureUploadingforMAC obj=new PictureUploadingforMAC(getApplicationContext(),"13014198-104@uog.edu.pk",bm);

        }
    }
    @Override
    public void onClick(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyAccountActivity.this);
        final EditText input = new EditText(MyAccountActivity.this);
        if(position==0)
        { changepass();}

        else if(position==1)
        {changenumber();}



    }
    private void changepass()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.customdialog1, null);
        dialogBuilder.setView(dialogView);

        final EditText oldpass = (EditText) dialogView.findViewById(R.id.oldpass);
        final EditText newpass = (EditText) dialogView.findViewById(R.id.newpass);
        final EditText cnfrmpass = (EditText) dialogView.findViewById(R.id.cnfrmpass);


        dialogBuilder.setTitle("Change Password");
        dialogBuilder.setMessage("Enter Password below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String a=oldpass.getText().toString();
                String b=newpass.getText().toString();
                String c=cnfrmpass.getText().toString();
                String e="13014198-103@uog.edu.pk";
                if(b.equals(c))
                {
                    changepass1 obj=new changepass1();
                    obj.execute(a,b,e);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"New Password Does not Match with Confirm Password",Toast.LENGTH_LONG).show();
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
               dialog.dismiss();
                           }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    private void changenumber()
    {

    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyAccountActivity.this);
        final EditText input = new EditText(MyAccountActivity.this);

    alertDialog.setTitle("PASSWORD");
        alertDialog.setMessage("Enter Password");
        type="Password";
        alertDialog.setView(input);


    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT);
    input.setLayoutParams(lp);

    alertDialog.setPositiveButton("YES",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    textFromDialog = input.getText().toString();
                    if(textFromDialog==null)
                        Toast.makeText(getApplicationContext(),"This filed can't be empty",Toast.LENGTH_SHORT).show();
                    else {
                        String e = "13014198-103@uog.edu.pk";
                        String a = input.getText().toString();
                        if (a.length() != 11) {
                            Toast.makeText(getApplicationContext(), "Invalid Number", Toast.LENGTH_LONG).show();
                        } else {
                            changemobile obj1 = new changemobile();
                            obj1.execute(a, e);
                        }
                    }
                }
            });
    alertDialog.setNegativeButton("NO",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
    alertDialog.show();

}
    private class changepass1 extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/changepass.php";
        String oldpass1;
        String newpass1;
        String mail;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                 oldpass1= params[0];
                newpass1 = params[1];
                mail=params[2];
                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);

                con.setRequestMethod("POST");

                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("userpass", "UTF-8") + "=" + URLEncoder.encode(oldpass1, "UTF-8") + "&" +
                        URLEncoder.encode("usernewpass", "UTF-8") + "=" + URLEncoder.encode(newpass1, "UTF-8") + "&" +
                        URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8");
                bw.write(data);
                bw.flush();
                bw.close();
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

            if(s.equals("Password Changed Successfully"))
            {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        }
    }
    private class changemobile extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/changemobile.php";
        String mob;
String m;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                mob=params[0];
                m=params[1];
                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);

                con.setRequestMethod("POST");

                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("usernum", "UTF-8") + "=" + URLEncoder.encode(mob, "UTF-8") + "&" +
                        URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(m, "UTF-8");
                bw.write(data);
                bw.flush();
                bw.close();
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

            if(s.equals("changed Successfully"))
            {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        }
    }
    }


