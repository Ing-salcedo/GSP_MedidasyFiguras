package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Cono extends AppCompatActivity {
    private EditText vradiocono, valturacono;
    private TextView vresultcono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        vradiocono = findViewById(R.id.txtVlrRadioCono);
        valturacono = findViewById(R.id.txtVlrAlturaCono);
        vresultcono = findViewById(R.id.lblResultadoCono);
    }

    public void calcularcono(View v){
        double radio, altura, result;
        String opereali = getString(R.string.volumen_cono), dato;
        Operacion o;

        if (validarcono()){
            radio = Double.parseDouble(vradiocono.getText().toString());
            altura = Double.parseDouble(valturacono.getText().toString());
            result = (Math.PI * Math.pow(radio,2) * altura)/3;
            vresultcono.setText(getString(R.string.volumen_cono)+": "+String.format("%.2f",result));
            String strradio = new Double(radio).toString();
            String straltura = new Double(altura).toString();
            dato = getString(R.string.valor_radio)+" "+strradio+"\n"+getString(R.string.valor_altura)+" "+straltura;
            o = new Operacion(opereali, dato,result);
            o.guardar();
        }
    }

    public boolean validarcono(){
        if(vradiocono.getText().toString().isEmpty()){
            vradiocono.setError(getString(R.string.mensaje_error_radio));
            vradiocono.requestFocus();
            return false;
        }
        if(valturacono.getText().toString().isEmpty()){
            valturacono.setError(getString(R.string.mensaje_error_altura));
            valturacono.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarcono(View v){
        vradiocono.setText("");
        valturacono.setText("");
        vresultcono.setText("");
        vradiocono.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

}