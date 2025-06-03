package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
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
    private EditText daneWlasciciela, celWizyty;
    private TextView wiek;
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
        potwierdz = findViewById(R.id.confirm);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.gatunek, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gatunek.setAdapter(adapter1);

        gatunek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUnit = parent.getItemAtPosition(position).toString();
                if(selectedUnit == "Pies"){
                    seekBar.setMax(18);
                } else if(selectedUnit == "Kot"){
                    seekBar.setMax(20);
                } else if(selectedUnit == "Świnka Morska") {
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

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Zaczynasz regulację!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}