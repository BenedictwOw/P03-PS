package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import static android.media.CamcorderProfile.get;


public class InfoActivity extends AppCompatActivity {
    int requestCodeForC347;
    ListView lv;
    TextView tvWeek,tvDG,tvGrade;
    ArrayAdapter aa;
    Button btnInfo,btnAdd,btnEmail;
    ArrayList<Weeks> weeks;
    String week = "";
    String dg = "";
    public static final String mypreference = "mypref";
    public static final String Reflection = "reflectionKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Intent i =getIntent();
        final String info = i.getStringExtra("info");
        this.setTitle("Info for "+ info);
        lv = (ListView)this.findViewById(R.id.lv2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnInfo = (Button) findViewById(R.id.btnInfo);


        weeks = new ArrayList<Weeks>();
        weeks.add(new Weeks("1", "B"));
        weeks.add(new Weeks("2","C"));
        weeks.add(new Weeks("3","A"));


        aa = new WeeksAdapter(this,R.layout.row2,weeks);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this,AddActivity.class);
                int s = (int)weeks.size();
                String size = Integer.toString(s + 1);
                i.putExtra("size",size);
                startActivityForResult(i,requestCodeForC347);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(info.contentEquals("C347")){
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/diploma-in-digital-design-and-development"));
                    startActivity(rpIntent);
                }else{
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                    startActivity(rpIntent);
                }

            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvWeek = findViewById(R.id.tvWeek);
                tvDG = findViewById(R.id.tvDG);
                tvGrade = findViewById(R.id.tvGrade);
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                for(int i=0; i < weeks.size(); i++){
                    dg = weeks.get(i).getDg();
                   week += "Week "+ (i+1) + " DG: "+dg +"\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, "Hi faci,\n\n I am Benedict Lim\nPlease see my remarks so far, thank you!\n\n"+week
                );
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK){
            if(data!=null){
                Weeks newData = (Weeks)data.getSerializableExtra("data");
                weeks.add(new Weeks(newData.getWeeks(), newData.getDg()));
                if(requestCode == requestCodeForC347){
                    lv.setAdapter(aa);
                }
            }
        }
    }
}

