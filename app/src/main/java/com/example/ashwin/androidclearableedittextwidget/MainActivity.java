package com.example.ashwin.androidclearableedittextwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ClearableEditText mClearableEditText;
    TextView mSavedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating instance of clearable edittext class
        mClearableEditText = new ClearableEditText(this);

        //placing it at position 1 in linearlayout
        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
        layout.addView(mClearableEditText, 1);

        mSavedText = (TextView) findViewById(R.id.savedtext);
    }

    //saving text from clearable edittext
    public void save(View view) {
        Toast.makeText(this, mClearableEditText.getText() + " is saved", Toast.LENGTH_LONG).show();
        mSavedText.setText(mClearableEditText.getText());
    }

    //clearing saved text
    public void clear(View view) {
        mSavedText.setText("");
    }
}
