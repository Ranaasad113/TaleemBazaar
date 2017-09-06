package com.asad.taleembazar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.asad.taleembazar.R;

public class SearchActivity extends AppCompatActivity {

    private TextInputEditText search;
    private Button searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = (TextInputEditText) findViewById(R.id.searchedittxt);
        searchbtn = (Button) findViewById(R.id.searchbtn);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search.getText().toString() == "") {
                    Snackbar.make(searchbtn, "Please specify field", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SearchActivity.this, ShowAllAddsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
