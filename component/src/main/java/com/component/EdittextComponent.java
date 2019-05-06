package com.component;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class EdittextComponent extends AppCompatEditText {
    Context context;
    public EdittextComponent(Context context) {
        super(context);
        this.context = context;
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        super.setPadding(10 , 10 , 10 , 10);
        super.setTextSize(15);
    }

    public EdittextComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        super.setPadding(10 , 10 , 10 , 10);
        super.setTextSize(15);
    }

    public EdittextComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        super.setPadding(10 , 10 , 10 , 10);
        super.setTextSize(15);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused){
            super.setHint("Focused");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused));
        } else {
            super.setHint("focus removed");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        }
        super.setPadding(10 , 10 , 10 , 10);
        super.setTextSize(15);
    }
}
