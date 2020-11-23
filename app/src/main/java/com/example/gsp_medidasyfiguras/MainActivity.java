package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lista_opciones;
    private String opciones[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_opciones = findViewById(R.id.lstOpciones);
        opciones = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones);
        lista_opciones.setAdapter(adapter);
    }
}