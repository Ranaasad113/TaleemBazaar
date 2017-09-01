package com.asad.taleembazar.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdapterMyAccount;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import com.asad.taleembazar.fragments.RegisterFragment;
import com.asad.taleembazar.serlization.MyAccountData;

public class MyAccountActivity extends AppCompatActivity implements RegisterFragment.Communication {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerAdapterMyAccount mAdapter;
    private ArrayList<MyAccountData> mArrayList = new ArrayList<>();
    private static final int REQUEST_CAPTURE = 1;
    private CircleMenu mCircleMenu;
    private static final int REQUEST_GALLERY_CODE = 2;
    private RecyclerView.LayoutManager mLayoutManager;

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
        mArrayList.add(new MyAccountData(R.drawable.personalinfo_icon, "Personal Information"));
        mArrayList.add(new MyAccountData(R.drawable.changepassword_icon, "Change Password"));
        mArrayList.add(new MyAccountData(R.drawable.changemail_icon, "Change Email"));
        mArrayList.add(new MyAccountData(R.drawable.changephoneno_icon, "Change Mobile No"));
        mArrayList.add(new MyAccountData(0, "Sign Out"));
        mAdapter = new RecyclerAdapterMyAccount(mArrayList);
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

    }


