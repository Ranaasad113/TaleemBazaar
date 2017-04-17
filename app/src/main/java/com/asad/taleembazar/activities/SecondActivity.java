package com.asad.taleembazar.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdapterForSubmitadd;
import com.asad.taleembazar.adpaters.RecyclerAdapterMyAccount;
import com.asad.taleembazar.adpaters.RecyclerAdpaterCategories;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import com.asad.taleembazar.fragments.FirstFragment;
import com.asad.taleembazar.serlization.MyAccountData;

public class SecondActivity extends AppCompatActivity implements FirstFragment.Communication {
    private Toolbar toolbar;
    private String checking = null;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<MyAccountData> arrayList = new ArrayList<>();
    private int i = 0;
    private static final int REQUEST_CAPTURE = 1;
    private CircleMenu circleMenu;
    private static final int REQUEST_GALLERY_CODE = 2;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentview();

    }

    @Override
    public void onBackPressed() {
        i--;
        if (i == 0)
            toolbar.setTitle("Sign In");
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

    private int toolbarForActivity(String value) //THis Function Set the Toolbar On the Activity
    {
        switch (value) {
            case "Sign In": {
                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Sign In ");
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                return 0;

            }
            case "My Account": {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                CollapsingToolbarLayout collapsingToolbar =
                        (CollapsingToolbarLayout) findViewById(R.id.collapse);
                collapsingToolbar.setTitle("Rana Asad");
                collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white_color));
                collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white_color));
                collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
                recyclerView = (RecyclerView) findViewById(R.id.recyclerview_for_myaccount);
                layoutManager = new GridLayoutManager(this, 1);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                arrayList.add(new MyAccountData(R.drawable.personalinfo_icon, "Personal Information"));
                arrayList.add(new MyAccountData(R.drawable.changepassword_icon, "Change Password"));
                arrayList.add(new MyAccountData(R.drawable.changemail_icon, "Change Email"));
                arrayList.add(new MyAccountData(R.drawable.changephoneno_icon, "Change Mobile No"));
                arrayList.add(new MyAccountData(0, "Sign Out"));
                adapter = new RecyclerAdapterMyAccount(arrayList);
                recyclerView.setAdapter(adapter);
                break;
            }
            case "For SubmitAdd": {

                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Submit Add");
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                return 0;

            }

        }
        return 0;
    }

    private int clickOnNoAccountTextview()//This Function  is onclick listener for the textview on no account
    {
        i++;
        int value=4219;
        String type=null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FirstFragment fragmentUsage = new FirstFragment();
        fragmentTransaction.add(R.id.coordinatelayout, fragmentUsage);
        toolbar.setTitle("Register");
        fragmentUsage.acceptValueActivity(value,this,type);
        fragmentTransaction.addToBackStack("Fragment_1");
        fragmentTransaction.commit();
        return 0;
    }


    public void accept(int j) {
        i = j;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setProfileImage(requestCode, resultCode, data);
    }

    private void setCircleMenu() {//In this Method the Circle Menu is set
        circleMenu.setMainMenu(Color.TRANSPARENT, R.drawable.camerra_for_pr0filepic, R.drawable.camerra_for_pr0filepic);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.drawable.camera_icon_for_submitadds)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.image_gallery_icon);
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

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

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

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

        }
    }
    private void setContentview()
    {
        Intent intent = getIntent();
        String check = intent.getStringExtra("Check");
        switch (check) {
            case "From Sign In": {
                checking = "Sign In";
                setContentView(R.layout.sign_in_layout);
                toolbar = (Toolbar) findViewById(R.id.toolbar_fragment);
                toolbarForActivity(checking);//Here's Toolbar of that Activity Set
                TextView no_account = (TextView) findViewById(R.id.no_account_register_textview);
                no_account.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickOnNoAccountTextview();
                    }
                });
                break;
            }
            case "From My Account": {
                checking = "My Account";
                this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                setContentView(R.layout.myaccount);
                toolbar = (Toolbar) findViewById(R.id.toolbarmyaccount);
                circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
                setCircleMenu();
                toolbarForActivity(checking);//Here's Toolbar of that Activity Set
                break;
            }
            case "For SubmitAdd": {
                checking = "For SubmitAdd";
                setContentView(R.layout.submitadd_layout);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                toolbar = (Toolbar) findViewById(R.id.toolbar_submitadd);
                RecyclerView recyclerViewforsubmitadd = (RecyclerView) findViewById(R.id.recyclerview_for_submitadd);
                layoutManager = new GridLayoutManager(this, 1);
                recyclerViewforsubmitadd.setLayoutManager(layoutManager);
                recyclerViewforsubmitadd.setHasFixedSize(true);
                adapter = new RecyclerAdapterForSubmitadd();
                recyclerViewforsubmitadd.setAdapter(adapter);
                toolbarForActivity(checking);//Here's Toolbar of that Activity Set
                break;


            }

        }
    }


}