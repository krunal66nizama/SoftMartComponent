package com.component;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

public class CheckBoxComponent extends AppCompatCheckBox {
    public CheckBoxComponent(Context context) {
        super(context);
    }

    public CheckBoxComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckBoxComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
