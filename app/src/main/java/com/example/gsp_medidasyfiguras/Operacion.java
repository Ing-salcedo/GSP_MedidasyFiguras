package com.example.gsp_medidasyfiguras;

public class Operacion {
    private String operealizada;
    private String data;
    private double result;

    public Operacion(String operealizada, String data, double result){
        this.operealizada = operealizada;
        this.data = data;
        this.result = result;
    }

    public String getOperealizada() {
        return operealizada;
    }

    public void setOperealizada(String operealizada) {
        this.operealizada = operealizada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void guardar(){
        Datos.guardar(this);
    }


}
