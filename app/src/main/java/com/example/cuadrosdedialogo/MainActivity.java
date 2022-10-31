package com.example.cuadrosdedialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

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

        calendario =  Calendar.getInstance(TimeZone.getTimeZone("CDT"));
    }//onCreate

    public void mostrarCuadroBasico(View view){
        //Instancia cuadro de dialogo
        AlertDialog.Builder cuadroID = new AlertDialog.Builder(MainActivity.this,R.style.Theme_CuadrosDeDialogo);
        //Titulo ventana cuadro de dialogo
        cuadroID.setMessage("Borrar toda la informacion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(MainActivity.this, "Informacion BorraDA", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(MainActivity.this, "Sin borrar informacion", Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }
}