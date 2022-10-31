package com.example.cuadrosdedialogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Instancias
    private EditText txtFecha, txtHora;
    private int dia, mes, hora, minutos;
    private Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFecha = (EditText) findViewById(R.id.edtFecha);
        txtHora = (EditText) findViewById(R.id.edtHora);
    }
}