package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Ope_Realizadas extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Operacion> operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ope__realizadas);

        tabla = findViewById(R.id.tblOperaciones);
        operaciones = Datos.obtener();

        for (int i = 0; i < operaciones.size(); i++) {
            TableRow fila = new TableRow(this);

            TextView columna_uno = new TextView(this);
            TextView columna_dos = new TextView(this);
            TextView columna_tres = new TextView(this);
            TextView columna_cuatro = new TextView(this);

            columna_uno.setText(""+(i+1));
            columna_dos.setText(operaciones.get(i).getOperealizada());
            columna_tres.setText(operaciones.get(i).getData());
            columna_cuatro.setText(String.format("%.2f",operaciones.get(i).getResult()));

            fila.addView(columna_uno);
            fila.addView(columna_dos);
            fila.addView(columna_tres);
            fila.addView(columna_cuatro);

            columna_uno.setGravity(View.TEXT_ALIGNMENT_CENTER);
            tabla.addView(fila);
        }
    }
}