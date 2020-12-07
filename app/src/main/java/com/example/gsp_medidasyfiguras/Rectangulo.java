package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Rectangulo extends AppCompatActivity {
    private EditText vbaserectan, valturarectan;
    private TextView vresultadorectan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        vbaserectan = findViewById(R.id.txtBaseRectangulo);
        valturarectan = findViewById(R.id.txtAlturaRectangulo);
        vresultadorectan = findViewById(R.id.lblResRectangulo);
    }

    public void calcularRectan(View v){
        double base, altura, result;
        String opereali = getString(R.string.area_del_rectangulo), dato;
        Operacion o;

        if (validar()){
            base = Double.parseDouble(vbaserectan.getText().toString());
            altura = Double.parseDouble(valturarectan.getText().toString());
            result = base * altura;
            vresultadorectan.setText(getString(R.string.area_del_rectangulo)+": "+String.format("%.2f",+result));
            String strbase = new Double(base).toString();
            String straltura = new Double(altura).toString();
            dato = getString(R.string.valor_base)+" "+strbase+"\n"+getString(R.string.valor_altura)+" "+straltura;
            o = new Operacion(opereali, dato,result);
            o.guardar();
        }
    }

    public boolean validar(){
        if(vbaserectan.getText().toString().isEmpty()){
            vbaserectan.setError(getString(R.string.mensaje_error_base));
            vbaserectan.requestFocus();
            return false;
        }
        if(valturarectan.getText().toString().isEmpty()){
            valturarectan.setError(getString(R.string.mensaje_error_altura));
            valturarectan.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarRectangulo(View v){
        vbaserectan.setText("");
        valturarectan.setText("");
        vresultadorectan.setText("");
        vbaserectan.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}