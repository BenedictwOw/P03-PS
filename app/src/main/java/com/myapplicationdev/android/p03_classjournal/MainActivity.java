package com.myapplicationdev.android.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    TextView tv;
    ArrayAdapter aa;
    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.lv);
        modules = new ArrayList<Module>();
        modules.add(new Module("C302","Web Services"));
        modules.add(new Module("C347","Android Porgrammin II"));
        aa = new ModuleAdapter(this,R.layout.row,modules);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = modules.get(position);
                String info = selectedModule.getModule();
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                i.putExtra("info",info);
                startActivity(i);
            }
        });
    }
}
