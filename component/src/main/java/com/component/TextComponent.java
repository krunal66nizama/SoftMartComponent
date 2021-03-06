package com.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

public class TextComponent extends AppCompatTextView {
    public TextComponent(Context context) {
        super(context);
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
    }

    public TextComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
    }

    public TextComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
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

    /*public void setDefault() {
        super.setPadding(20, 20, 20, 20);
        super.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
    }*/
}
