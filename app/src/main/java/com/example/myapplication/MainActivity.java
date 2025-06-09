package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private Spinner gatunek;
    private TimePicker czas;
    private EditText daneWlasciciela, celWizyty;
    private TextView wiek, info;
    private Button potwierdz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        gatunek = findViewById(R.id.gatunekSpinner);
        daneWlasciciela = findViewById(R.id.daneWlasciciela);
        celWizyty = findViewById(R.id.celWizyty);
        wiek = findViewById(R.id.wiek);
        info = findViewById(R.id.informacje);
        potwierdz = findViewById(R.id.potwierdz);
        czas = findViewById(R.id.timePicker);

        czas.setHour(16);
        czas.setMinute(0);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.gatunek, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gatunek.setAdapter(adapter1);

        gatunek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUnit = parent.getItemAtPosition(position).toString();
                if(selectedUnit.equals("Pies")){
                    seekBar.setMax(18);
                } else if(selectedUnit.equals("Kot")){
                    seekBar.setMax(20);
                } else if(selectedUnit.equals("Świnka Morska")) {
                    seekBar.setMax(9);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                wiek.setText(String.valueOf(progressValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        potwierdz.setOnClickListener(view -> {
            info.setText(daneWlasciciela.getText() + ", " + gatunek.getSelectedItem() + ", " + wiek.getText() + ", "
                    + celWizyty.getText() + ", " + czas.getHour() + ":" + czas.getMinute());
        });

    }
}