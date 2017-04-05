package com.example.slawomirmakurat.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Main2Activity extends Activity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title = (TextView) findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        String title12 = bundle.getString("title12");
        String title22 = bundle.getString("title22");
        title.setText(title12 + title22);
    }

}
