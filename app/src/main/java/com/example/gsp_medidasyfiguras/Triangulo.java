package com.example.gsp_medidasyfiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Triangulo extends AppCompatActivity {
    private EditText vbasetriang, valturatriang;
    private TextView vresultadotriang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        vbasetriang = findViewById(R.id.txtBaseTriangulo);
        valturatriang = findViewById(R.id.txtAlturaTriangulo);
        vresultadotriang = findViewById(R.id.lblResTriangulo);
    }

    public void calcularTriangulo(View v){
        double base, altura, result;
        String opereali = getString(R.string.area_del_triangulo), dato;
        Operacion o;

        if (validar()){
            base = Double.parseDouble(vbasetriang.getText().toString());
            altura = Double.parseDouble(valturatriang.getText().toString());
            result = (base * altura)/2;
            vresultadotriang.setText(getString(R.string.area_del_triangulo)+": "+String.format("%.2f",result));
            String strbase = new Double(base).toString();
            String straltura = new Double(altura).toString();
            dato = getString(R.string.valor_base)+" "+strbase+"\n"+getString(R.string.valor_altura)+" "+straltura;
            o = new Operacion(opereali, dato,result);
            o.guardar();
        }
    }

    public boolean validar(){
        if(vbasetriang.getText().toString().isEmpty()){
            vbasetriang.setError(getString(R.string.mensaje_error_base));
            vbasetriang.requestFocus();
            return false;
        }
        if(valturatriang.getText().toString().isEmpty()){
            valturatriang.setError(getString(R.string.mensaje_error_altura));
            valturatriang.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiarTriangulo(View v){
        vbasetriang.setText("");
        valturatriang.setText("");
        vresultadotriang.setText("");
        vbasetriang.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}