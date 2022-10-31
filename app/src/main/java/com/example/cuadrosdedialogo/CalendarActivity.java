package com.example.cuadrosdedialogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    //Instancia
    CalendarView cal;
    private int dia, mes, anio, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        cal = findViewById(R.id.cvCalendario);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fecha = year + "/" + month + "/" + dayOfMonth;
                Toast.makeText(CalendarActivity.this, fecha, Toast.LENGTH_SHORT).show();
            }
        });

    }
}