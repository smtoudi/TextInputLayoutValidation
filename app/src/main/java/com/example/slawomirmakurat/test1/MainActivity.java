package com.example.slawomirmakurat.test1;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    private EditText title, text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextInputLayout title_ad_layout = (TextInputLayout) findViewById(R.id.add_title_ad_layout);
        final TextInputLayout text_ad_layout = (TextInputLayout) findViewById(R.id.add_text_ad_layout);
        final TextInputEditText title_Ad_editText = (TextInputEditText) findViewById(R.id.title_Ad_editText);
        final TextInputEditText text_Ad_editText = (TextInputEditText) findViewById(R.id.text_Ad_editText);
        setTextWatcher(title_Ad_editText, title_ad_layout);
        setTextWatcher(text_Ad_editText, text_ad_layout);
        

        title = (EditText) findViewById(R.id.title_Ad_editText);
        text = (EditText) findViewById(R.id.text_Ad_editText);

        btn = (Button) findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean error = false;

                if (TextUtils.isEmpty(title_Ad_editText.getText().toString())) {
                    title_ad_layout.setError(getString(R.string.empty_field));
                    error = true;
                }
                if (TextUtils.isEmpty(text_Ad_editText.getText().toString())) {
                    text_ad_layout.setError(getString(R.string.empty_field));
                    error = true;
                }
                if (!error) {
                    nextpage();
                }
            }
        });

    }

    private void setTextWatcher(final TextInputEditText editText, final TextInputLayout inputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (inputLayout.isErrorEnabled()) {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void nextpage() {

        Intent i = new Intent(this, Main2Activity.class);

        String imie = title.getText().toString();
        String nazwusko = text.getText().toString();


        i.putExtra("title12", imie);
        i.putExtra("title22", nazwusko);
        startActivity(i);
    }


}