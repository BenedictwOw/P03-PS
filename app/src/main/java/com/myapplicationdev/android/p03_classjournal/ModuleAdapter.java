package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ModuleAdapter extends ArrayAdapter<Module> {
    private TextView tvModule,tvName;
    private ArrayList<Module> modules;
    private Context context;
    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Module currentModule = modules.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvModule = (TextView)rowView.findViewById(R.id.tvMod);
        tvName = (TextView)rowView.findViewById(R.id.tvModName);
        tvModule.setText(currentModule.getModule());
        tvName.setText(currentModule.getName());
        return rowView;
    }
}
