package com.farenza.dompet;

import android.content.Intent;
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
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("Value", 15);
        startActivity(intent);
        // Here you want to show the user a dialog box
        finish();
    }
}
