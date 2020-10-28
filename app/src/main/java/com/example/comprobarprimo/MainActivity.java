package com.example.comprobarprimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private EditText number;
    private Button boton;
    private View v;
    private Button botonLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.calcular);
        number= (EditText) findViewById(R.id.numero);
        resultado =(TextView) findViewById(R.id.resultado);
        botonLimpiar = (Button ) findViewById(R.id.limpiar);
    }
    public void ComprobarPrimo(View v) {

        boolean primo = true;
        String numero = number.getText().toString();
        String mensaje;
        int num = Integer.parseInt(numero);
        try {
            if (numero.isEmpty()) {
                mensaje = "Introduce un número";
                resultado.setText(mensaje);

            } else {
                for (int i = 2; i <= Math.sqrt(num) && primo; i++) {
                    if ((num % i) == 0) {
                        primo = false;

                    }
                }
            }
            if (primo) {
                mensaje = ("El número " + num + " es primo");
                resultado.setText(mensaje);
            } else {
                mensaje = ("El número " + num + " no  es primo");
                resultado.setText(mensaje);
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();

        }
    }
    public void Limpiar(View v){
        resultado.setText("Introduce un número");
        number.setText("");
    }
}