package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Cilindro extends AppCompatActivity {
    private EditText vradiocilin, valturacilin;
    private TextView vresultcilin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        vradiocilin = findViewById(R.id.txtVlrRadioCilindro);
        valturacilin = findViewById(R.id.txtVlrAlturaCilindro);
        vresultcilin = findViewById(R.id.lblResultadoCilindro);
    }

    public void calcularcilindro(View v){
        double radio, altura, result;
        String opereali = getString(R.string.volumen_cilindro), dato;
        Operacion o;

        if (validarcilindro()){
            radio = Double.parseDouble(vradiocilin.getText().toString());
            altura = Double.parseDouble(valturacilin.getText().toString());
            result = Math.PI * Math.pow(radio,2) * altura;
            vresultcilin.setText(getString(R.string.volumen_cilindro)+": "+String.format("%.2f",result));
            String strradio = new Double(radio).toString();
            String straltura = new Double(altura).toString();
            dato = getString(R.string.valor_radio)+" "+strradio+"\n"+getString(R.string.valor_altura)+" "+straltura;
            o = new Operacion(opereali, dato,result);
            o.guardar();
        }
    }

    public boolean validarcilindro(){
        if(vradiocilin.getText().toString().isEmpty()){
            vradiocilin.setError(getString(R.string.mensaje_error_radio));
            vradiocilin.requestFocus();
            return false;
        }
        if(valturacilin.getText().toString().isEmpty()){
            valturacilin.setError(getString(R.string.mensaje_error_altura));
            valturacilin.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarcilindro(View v){
        vradiocilin.setText("");
        valturacilin.setText("");
        vresultcilin.setText("");
        vradiocilin.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}