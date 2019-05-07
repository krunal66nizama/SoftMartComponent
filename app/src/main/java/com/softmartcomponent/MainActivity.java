package com.softmartcomponent;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Context context;
    TextView txt;
    Button btn;
    com.component.EdittextComponent edtComponent, edtComponent1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        edtComponent = findViewById(R.id.edtComponent);
        edtComponent1 = findViewById(R.id.edtComponent1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt.setText(edtComponent.getValue());
                /*if (edtComponent.getText().length() > 0) {
                    String cleanString = edtComponent.getText().toString().replaceAll("[₹$,.]", "");
                    cleanString = cleanString.replaceAll("\\s", "");

                    double parsed = Double.parseDouble(cleanString);
                    txt.setText(String.valueOf(parsed / 100));
                    txt.setText(edtComponent.getValue());
                }*/
            }
        });
    }
}