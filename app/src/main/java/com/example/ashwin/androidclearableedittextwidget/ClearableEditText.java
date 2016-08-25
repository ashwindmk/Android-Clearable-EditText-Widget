package com.example.ashwin.androidclearableedittextwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by ashwin on 24/8/16.
 */

public class ClearableEditText extends LinearLayout implements View.OnClickListener {

    EditText mEditText;
    Button mClearText;
    String str_text;
    AttributeSet attrs;

    public ClearableEditText(Context context) {
        super(context);
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        //initialization
        View.inflate(context, R.layout.clearable_edittext_layout, this);

        mEditText = (EditText) findViewById(R.id.editText);

        mClearText = (Button) findViewById(R.id.clearText);

        mClearText.setVisibility(INVISIBLE);

        mClearText.setOnClickListener(this);

        if(attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ClearableEditTextAttributes, 0, 0);

            str_text = a.getString(R.styleable.ClearableEditTextAttributes_text);

            mEditText.setText(str_text);

            a.recycle();
        }

        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    mClearText.setVisibility(View.VISIBLE);
                    str_text = s.toString();
                } else {
                    mClearText.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    public String getText() {
        return str_text;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.clearText:
                mEditText.setText("");
                mClearText.setVisibility(View.INVISIBLE);
        }
    }
}
