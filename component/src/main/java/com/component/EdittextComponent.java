package com.component;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;

import java.text.NumberFormat;

public class EdittextComponent extends AppCompatEditText {
    Context context;

    public EdittextComponent(Context context) {
        super(context);
        this.context = context;
        setDefault();

    }

    public EdittextComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setDefault();
    }

    public EdittextComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setDefault();
    }

    String current = "";

    public void setDefault() {
        super.setPadding(20, 20, 20, 20);
        super.setTextSize(20);
        super.setInputType(InputType.TYPE_CLASS_NUMBER);


        super.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    removeTextChangedListener(this);

                    String cleanString = s.toString().replaceAll("[₹$,.]", "");
                    cleanString = cleanString.replaceAll("\\s", "");

                    double parsed = Double.parseDouble(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance().format((parsed / 100));

                    current = formatted;
                    setText(formatted);
                    setSelection(formatted.length());

                    addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public String getValue() {

        String value = "";
        if (getText().length() > 0) {
            String cleanString = getText().toString().replaceAll("[₹$,.]", "");
            cleanString = cleanString.replaceAll("\\s", "");

            double parsed = Double.parseDouble(cleanString);
            value = String.valueOf(parsed / 100);
        }

        return value;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            super.setHint("Focused");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused));
        } else {
            super.setHint("Focus Removed");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        }
    }
}