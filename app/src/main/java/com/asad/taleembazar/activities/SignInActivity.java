package com.asad.taleembazar.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.asad.taleembazar.R;
import com.asad.taleembazar.fragments.RegisterFragment;

public class SignInActivity extends AppCompatActivity implements RegisterFragment.Communication {
  private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_fragment);
        settingToolbar();//Here's Toolbar of that Activity Set
        TextView no_account = (TextView) findViewById(R.id.no_account_register_textview);
        no_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOnNoAccountTextview();
            }
        });
    }

    private void settingToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Sign In ");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private int clickOnNoAccountTextview()//This Function  is onclick listener for the textview on no account
    {
        int value=4219;
        String type=null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        RegisterFragment fragmentUsage = new RegisterFragment();
        fragmentTransaction.add(R.id.coordinatelayout, fragmentUsage);
        mToolbar.setTitle("Register");
        fragmentUsage.acceptValueActivity(value,this,type);
        fragmentTransaction.addToBackStack("Fragment_1");
        fragmentTransaction.commit();
        return 0;
    }

    @Override
    public void accept(int i) {

    }
}
