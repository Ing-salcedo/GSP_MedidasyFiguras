package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Circulo extends AppCompatActivity {
    private EditText vradio;
    private TextView vresultadocirculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        vradio = findViewById(R.id.txtVlrRadioCirculo);
        vresultadocirculo = findViewById(R.id.lblResultadoCirculo);
    }

    public void calcularcirculo(View v){
        double valradio, res;
        String opereali = getString(R.string.area_del_circulo);
        String dato;
        Operacion o;

        if (validarcirculo()) {
            valradio = Double.parseDouble(vradio.getText().toString());
            res = 3.1416 * Math.pow(valradio,2);
            vresultadocirculo.setText(getString(R.string.area_del_circulo)+": " +String.format("%.2f",res));
            String strradio = new Double(valradio).toString();
            dato = getString(R.string.valor_radio) + " " + strradio;
            o = new Operacion(opereali, dato,res);
            o.guardar();
        }
    }

    public boolean validarcirculo(){
        if(vradio.getText().toString().isEmpty()){
            vradio.setError(getString(R.string.mensaje_error_circulo));
            vradio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarcirculo(View v){
        vradio.setText("");
        vresultadocirculo.setText("");
        vradio.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}