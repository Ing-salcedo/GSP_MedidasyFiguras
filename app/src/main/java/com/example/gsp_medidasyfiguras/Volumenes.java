package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumenes extends AppCompatActivity {
    private ListView lista_volumenes;
    private String volumenes[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        lista_volumenes = findViewById(R.id.lstVolumenes);
        volumenes = getResources().getStringArray(R.array.arrvolumenes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,volumenes);
        lista_volumenes.setAdapter(adapter);

        lista_volumenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent = new Intent(Volumenes.this, Esfera.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Volumenes.this, Cilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Volumenes.this, Cono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Volumenes.this, Cubo.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}