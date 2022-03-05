package com.example.calculadora2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText muestra;
    boolean nuevoOperador = true;
    String op = "+";
    String numeroAnterior= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muestra = findViewById(R.id.editText);
    }

    public void numeroEvento(View view) {

        if(nuevoOperador)
            muestra.setText("");
        nuevoOperador = false;

        String numero = muestra.getText().toString();

        switch (view.getId()){

            case R.id.uno:
                numero +="1";
                break;
            case R.id.dos:
                numero +="2";
                break;
            case R.id.tres:
                numero +="3";
                break;

            case R.id.cuatro:
                numero +="4";
                break;
            case R.id.cinco:
                numero +="5";
                break;
            case R.id.seis:
                numero +="6";
                break;

            case R.id.siete:
                numero += "7";
                break;

            case R.id.ocho:
                numero +="8";
                break;

            case R.id.nueve:
                numero +="9";
                break;

            case R.id.cero:
                numero +="0";
                break;
            case R.id.decimal:
                numero +=".";
                break;
            case R.id.masmenos:
                numero = "-"+numero;
                break;

        }
        muestra.setText(numero);

    }

    public void eventoOperador(View view) {
        nuevoOperador = true;
        numeroAnterior = muestra.getText().toString();
        switch (view.getId()){

            case R.id.dividir:
                op="/";
                break;

            case R.id.multiplicar:
                op="x";
                break;

            case R.id.sumar:
                op="+";
                break;

            case R.id.restar:
                op="-";
                break;
        }

    }

    public void eventoResultado(View view) {
        String newNumero = muestra.getText().toString();
        double resultado = 0.0;
        switch (op){
            case "+":
                resultado = Double.parseDouble(numeroAnterior)+ Double.parseDouble(newNumero);
                break;
            case "-":
                resultado = Double.parseDouble(numeroAnterior)- Double.parseDouble(newNumero);
                break;
            case "x":
                resultado = Double.parseDouble(numeroAnterior)* Double.parseDouble(newNumero);
                break;
            case "/":
                resultado = Double.parseDouble(numeroAnterior) / Double.parseDouble(newNumero);
                break;
        }
        muestra.setText(resultado+"");
    }

    public void limpiar(View view) {
        muestra.setText("0");
        nuevoOperador = true;
    }

   /* public void porciento(View view) {

        double no= Double.parseDouble(muestra.getText().toString())/100;
        muestra.setText(no+"");

        nuevoOperador= true;

    }*/
}