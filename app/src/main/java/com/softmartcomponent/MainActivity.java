package com.softmartcomponent;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    com.component.TextComponent textComponent;
    com.component.EdittextComponent edtComponent , edtComponent1;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textComponent = findViewById(R.id.textComponent);
        edtComponent = findViewById(R.id.edtComponent);
        edtComponent1 = findViewById(R.id.edtComponent1);
        //textComponent.setBackground(getResources().getDrawable(R.drawable.black));
        textComponent.setBackgroundColor(getResources().getColor(R.color.black));
    }
}