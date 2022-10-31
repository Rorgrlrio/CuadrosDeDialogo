package com.example.cuadrosdedialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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

    public void mostrarCuadroPersonalizado(View view) {
        //Crear instancia de cuadro de dialogo Alert
        AlertDialog.Builder cuadroDP = new AlertDialog.Builder(MainActivity.this, R.style.Theme_CuadrosDeDialogo);
        View vistaCuadro = LayoutInflater.from(MainActivity.this).inflate(
            R.layout.dialogo_personal,(ConstraintLayout)findViewById (R.id.contenedor));
        //
        cuadroDP.setView(vistaCuadro);
        //
        ((EditText) vistaCuadro.findViewById(R.id.edtMensaje)).setText("Cancela vuelo?");
        ((Button) vistaCuadro.findViewById(R.id.btnAceptar)).setText("Si");
        ((Button) vistaCuadro.findViewById(R.id.btnCancelar)).setText("No");
        //
        final AlertDialog alertDialog = cuadroDP.create();
        //
        Button aceptar = vistaCuadro. findViewById(R.id.btnAceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(getApplicationContext(), "VueloCanceladO", Toast.LENGTH_SHORT);
            }
        });

        Button cancelar = vistaCuadro.findViewById(R.id.btnCancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Vuelo sin cambvios", Toast.LENGTH_SHORT);
            }
        });
        alertDialog.show();
    } //mostrarCuadroPersonalizado
}