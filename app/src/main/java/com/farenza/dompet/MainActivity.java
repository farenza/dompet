package com.farenza.dompet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Construct the data source
        ArrayList<ModelIsi> arrayOfUsers = new ArrayList<ModelIsi>();
// Create the adapter to convert the array to views
        final AdapterModelIsi adapter_class = new AdapterModelIsi(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.item_here);
        listView.setAdapter(adapter_class);

        // Add item to adapter
        ModelIsi newModelIsi_class = new ModelIsi("Nathan", 50000);
        adapter_class.add(newModelIsi_class);

        adapter_class.add(new ModelIsi("Obat-obatan",1000000));
        adapter_class.add(new ModelIsi("Belanja",5000000));
        adapter_class.add(new ModelIsi("Sekolah",20000000));
        adapter_class.add(new ModelIsi("Makan Minum",2500000));
        adapter_class.add(new ModelIsi("Kontrak",3560000));
        adapter_class.add(new ModelIsi("Ansuransi",500000));
        adapter_class.add(new ModelIsi("WiFi",350000));
        adapter_class.add(new ModelIsi("Listrik",1000000));
        adapter_class.add(new ModelIsi("Air",300000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));
        adapter_class.add(new ModelIsi("Lain-lain",52050000));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_TAMBAH);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PenambahanActivity.class);
                intent.putExtra("Value", 15);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ModelIsi classModelIsi = adapter_class.getItem(position);

                Snackbar.make(view, classModelIsi.nama_transaksi+"\n"+classModelIsi.nominal, Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }


        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this,SignInActivity.class));
        finish();
    }
}
