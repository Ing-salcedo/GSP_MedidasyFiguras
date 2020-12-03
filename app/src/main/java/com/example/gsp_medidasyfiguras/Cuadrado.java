package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Cuadrado extends AppCompatActivity {
    private EditText vlado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        vlado = findViewById(R.id.txtVlrLadoCuadrado);
        resultado = findViewById(R.id.lblResCuadrado);
    }

    public void calcular(View v){
        double val, res;
        String opereali = getString(R.string.area_del_cuadrado);
        String dato;
        Operacion o;

        if (validar()) {
            val = Double.parseDouble(vlado.getText().toString());
            res = val * val;
            resultado.setText(getString(R.string.area_del_cuadrado)+": " + res);
            String strval = new Double(val).toString();
            dato = getString(R.string.valor_lado) + " " + strval;
            o = new Operacion(opereali, dato,res);
            o.guardar();
        }
    }

    public boolean validar(){
        if(vlado.getText().toString().isEmpty()){
            vlado.setError(getString(R.string.mensaje_error_cuadrado));
            vlado.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        vlado.setText("");
        resultado.setText("");
        vlado.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}