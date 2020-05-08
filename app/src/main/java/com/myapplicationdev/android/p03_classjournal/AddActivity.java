package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    Button btnSubmit;
    TextView tvWeek;
    ImageView dg;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.setTitle("Add data for Week");
        tvWeek = findViewById(R.id.tvWeek2);
        dg = findViewById(R.id.ivDG2);
        btnSubmit = findViewById(R.id.btnSubmit);
        rg = (RadioGroup)findViewById(R.id.radioGroup1);
        Intent i = getIntent();
        final String s = i.getStringExtra("size");
        tvWeek.setText("Week " + s);
        dg.setImageResource(R.drawable.dg);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId);
                String grade = rb1.getText().toString();
                Intent i = new Intent(AddActivity.this,InfoActivity.class);
                Weeks newWeek = new Weeks(s,grade);
                i.putExtra("data",newWeek);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
