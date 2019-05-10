package com.component;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EdittextComponent extends AppCompatEditText {
    Context context;
    String current = "";
    String type = "";


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

    public void setDefault() {
        super.setPadding(20, 20, 20, 20);
        super.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        super.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                switch (type) {
                    case "price":

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
                        break;

                    case "phone": {
                        String text = s.toString();
                        int textLength = s.length();
                        if (text.endsWith("-") || text.endsWith(" ") || text.endsWith(")") || text.endsWith("("))
                            return;
                        if (textLength == 1) {
                            if (!text.contains("(")) {
                                setText(new StringBuilder(text).insert(text.length() - 1, "(").toString());
                                setSelection(getText().length());
                            }
                        } else if (textLength == 5) {
                            if (!text.contains(") ")) {
                                setText(new StringBuilder(text).insert(text.length() - 1, ") ").toString());
                                setSelection(getText().length());
                            }
                        } else if (textLength == 10) {
                            if (!text.contains(" - ")) {
                                setText(new StringBuilder(text).insert(text.length() - 1, "-").toString());
                                setSelection(getText().length());
                            }
                        }

                        break;
                    }
                    case "ssn": {


                        String text = s.toString();
                        text = text.toUpperCase();
                        int textLength = s.length();
                        if (text.endsWith("-") || text.endsWith(" "))
                            return;
                        if (count == 0) {
                            return;
                        } else if (textLength == 4) {

                            setText(new StringBuilder(text).insert(text.length() - 1, "-").toString());
                            setSelection(getText().length());

                        } else if (textLength == 7) {
                            int n = 0;

                            for (int i = 0; i < text.length(); i++) {
                                if (text.charAt(i) == '-')
                                    n++;
                            }

                            if (n < 2) {
                                setText(new StringBuilder(text).insert(text.length() - 1, "-").toString());
                                setSelection(getText().length());
                            }


                        } else {
                            removeTextChangedListener(this);
                            setText(text);
                            setSelection(getText().length());
                            addTextChangedListener(this);
                        }
                        break;
                    }

                    case "password":
                        break;

                    case "":
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void setType(String type) {
        super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        this.type = type;
        if (type.equalsIgnoreCase("price")) {
            super.setInputType(InputType.TYPE_CLASS_NUMBER);
            super.setHint("Price");
        } else if (type.equalsIgnoreCase("phone")) {
            super.setInputType(InputType.TYPE_CLASS_NUMBER);
            super.setHint("Phone");
            super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        } else if (type.equalsIgnoreCase("ssn")) {
            super.setInputType(InputType.TYPE_CLASS_TEXT);
            super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
            super.setHint("SSN");
        } else if (type.equalsIgnoreCase("password")) {
            super.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            super.setHint("Password");
        } else if (type.equalsIgnoreCase("datePicker")){
            super.setFocusable(false);
            super.setFocusableInTouchMode(false);
            super.setHint("Date Pick");

            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(context, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });
        } else {
            super.setInputType(InputType.TYPE_CLASS_TEXT);
            super.setHint("Type");
        }
    }

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            setText(sdf.format(myCalendar.getTime()));
        }

    };

    /*@Override
    public void setOnClickListener(View.OnClickListener l) {
        super.setOnClickListener(l);
        if (type.equalsIgnoreCase("datePicker")){

        }
    }*/

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
            //super.setHint("Focused");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused));
        } else {
            //super.setHint("Focus Removed");
            super.setBackground(context.getResources().getDrawable(R.drawable.focused_removed));
        }
    }
}