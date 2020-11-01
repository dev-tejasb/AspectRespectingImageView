package com.tejasb.aspectrespectingimageviewdemo;

import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatTextView sample1Desc = findViewById(R.id.sample_1_tv);
        sample1Desc.setText(Html.fromHtml(getString(R.string.sample_1_desc)));

        AppCompatTextView sample2Desc = findViewById(R.id.sample_2_tv);
        sample2Desc.setText(Html.fromHtml(getString(R.string.sample_2_desc)));
    }
}