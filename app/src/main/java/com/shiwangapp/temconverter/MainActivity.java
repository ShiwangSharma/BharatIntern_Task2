package com.shiwangapp.temconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_convert, btn_clear;
    EditText edt_temp;
    TextView tv_temp;
    RadioButton c2f, f2c;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_convert = findViewById(R.id.btn_convert);
        btn_clear = findViewById(R.id.btn_clear);
        edt_temp = findViewById(R.id.edt_temp);
        tv_temp = findViewById(R.id.tv_temp);
        c2f = findViewById(R.id.radio_c2f);
        f2c = findViewById(R.id.radio_f2c);

        btn_convert.setOnClickListener(v -> {
            if (edt_temp.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Enter Temperature", Toast.LENGTH_SHORT).show();
            }
            else {
                x = Double.parseDouble(String.valueOf(edt_temp.getText()));
                if (c2f.isChecked()){
                    x = (x*9)/5+32;
                    String y = String.format("%.2f", x);
                    tv_temp.setText(y+" °F");
                } else if (f2c.isChecked()) {
                    x=(x-32)*5/9;
                    String y = String.format("%.2f", x);
                    tv_temp.setText(y+" °C");

                }else {
                    Toast.makeText(this, "Please select the formula", Toast.LENGTH_SHORT).show();
                }
            }


        });
        btn_clear.setOnClickListener(v -> {
            edt_temp.setText("");
            tv_temp.setText("0.0");
            c2f.setChecked(false);
            f2c.setChecked(false);
        });


    }

}