package com.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class ButtonComponent extends AppCompatButton {
    public ButtonComponent(Context context) {
        super(context);
    }

    public ButtonComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setBackground(Drawable background) {
        //super.setBackground(background);
        backGround(background);
        setTextColor(Color.RED);
        super.setPadding(10 , 10 , 10 , 10);
    }

    @Override
    public void setTextColor(int color) {
        super.setTextColor(color);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void backGround(Drawable background){
        //setBackground(background);
        super.setBackground(background);
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        setTextColor(Color.MAGENTA);
        super.setPadding(10 , 10 , 10 , 10);
    }
}
