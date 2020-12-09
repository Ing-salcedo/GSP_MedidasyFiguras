package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Cubo extends AppCompatActivity {
    private EditText vlado;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        vlado = findViewById(R.id.txtVlrLadoCubo);
        resultado = findViewById(R.id.lblResCubo);
    }

    public void calcularCubo(View v){
        double val, res;
        String opereali = getString(R.string.volumen_cubo);
        String dato;
        Operacion o;

        if (validarcubo()) {
            val = Double.parseDouble(vlado.getText().toString());
            res = Math.pow(val,3);
            resultado.setText(getString(R.string.volumen_cubo)+": " +String.format("%.2f",res));
            String strval = new Double(val).toString();
            dato = getString(R.string.valor_lado) + " " + strval;
            o = new Operacion(opereali, dato,res);
            o.guardar();
        }
    }

    public boolean validarcubo(){
        if(vlado.getText().toString().isEmpty()){
            vlado.setError(getString(R.string.mensaje_error_lado));
            vlado.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarcubo(View v){
        vlado.setText("");
        resultado.setText("");
        vlado.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

}