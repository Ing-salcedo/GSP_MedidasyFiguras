package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Esfera extends AppCompatActivity {
    private EditText vradio;
    private TextView vresultesfera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        vradio = findViewById(R.id.txtVlrRadioEsfera);
        vresultesfera = findViewById(R.id.lblResultadoEsfera);
    }
    public void calcularesfera(View v){
        double valradio, res;
        String opereali = getString(R.string.volumen_esfera);
        String dato;
        Operacion o;

        if (validaresfera()) {
            valradio = Double.parseDouble(vradio.getText().toString());
            res = (4 * Math.PI * Math.pow(valradio,3))/3;
            vresultesfera.setText(getString(R.string.volumen_esfera)+": " +String.format("%.2f",res));
            String strradio = new Double(valradio).toString();
            dato = getString(R.string.valor_radio) + " " + strradio;
            o = new Operacion(opereali, dato,res);
            o.guardar();
        }
    }
    public boolean validaresfera(){
        if(vradio.getText().toString().isEmpty()){
            vradio.setError(getString(R.string.mensaje_error_radio));
            vradio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiaresfera(View v){
        vradio.setText("");
        vresultesfera.setText("");
        vradio.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}
