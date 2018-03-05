package com.farenza.dompet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PenambahanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penambahan);


    }
    @Override
    public void onBackPressed() {
        // Here you want to show the user a dialog box
        finish();
    }
}
