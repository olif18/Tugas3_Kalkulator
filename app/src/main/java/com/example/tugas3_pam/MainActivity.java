package com.example.tugas3_pam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char currentSymbol;

    private double nilai1 = Double.NaN;
    private double nilai2;
    private TextView input, input2, output;
    private DecimalFormat decimalFormat;
    private MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnKoma, btnTambah, btnKurang, btnKali, btnBagi, btnHapus, btnSamaDengan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        input = findViewById(R.id.input);
        input2 = findViewById(R.id.input2);
        output = findViewById(R.id.output);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnTambah = findViewById(R.id.btntambah);
        btnKurang = findViewById(R.id.btnkurang);
        btnBagi = findViewById(R.id.btnbagi);
        btnKoma = findViewById(R.id.btnkoma);
        btnKali = findViewById(R.id.btnkali);
        btnHapus = findViewById(R.id.btnhapus);
        btnSamaDengan = findViewById(R.id.btnsamadengan);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "9");
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                output.setText(decimalFormat.format(nilai1) + "+"); //siniii
                input.setText(null);
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = SUBTRACTION;
                output.setText(decimalFormat.format(nilai1) + "-");
                input.setText(null);
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                output.setText(decimalFormat.format(nilai1) + "x");
                input.setText(null);
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                input.setText(decimalFormat.format(nilai1) + "/");
                input.setText(null);
            }
        });

        btnKoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + ".");
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().length() > 0) {
                    CharSequence currentText = input.getText();
                    input.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    nilai1 = Double.NaN;
                    nilai2 = Double.NaN;
                    input.setText("");
                    output.setText("");
                }
            }
        });

        btnSamaDengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                output.setText(decimalFormat.format(nilai1));
                nilai1 = Double.NaN;
                currentSymbol = '0';
            }
        });
    }

    private void allCalculations(){
        if (!Double.isNaN(nilai1)) {
            nilai2 = Double.parseDouble(input.getText().toString());
            input.setText(null);

            if (currentSymbol == ADDITION)
                nilai1 = this.nilai1 + nilai2;
            else if (currentSymbol == SUBTRACTION)
                nilai1 = this.nilai1 - nilai2;
            else if (currentSymbol == MULTIPLICATION)
                nilai1 = this.nilai1 * nilai2;
            else if (currentSymbol == DIVISION)
                nilai1 = this.nilai1 / nilai2;
        } else {
            try {
                nilai1 = Double.parseDouble(input.getText().toString());
            } catch (Exception e) {

            }
        }
    }
}