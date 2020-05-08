package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class WeeksAdapter extends ArrayAdapter<Weeks> {
    private TextView tvWeek,tvDG;
    private ImageView ivImage;
    private ArrayList<Weeks> weeks;
    private Context context;
;
    public WeeksAdapter(Context context, int resource, ArrayList<Weeks> objects) {
        super(context, resource, objects);
        weeks = objects;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Weeks currentWeek = weeks.get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row2, parent, false);
        tvWeek = (TextView)rowView.findViewById(R.id.tvWeek);
        tvDG = (TextView)rowView.findViewById(R.id.tvGrade);
        ivImage = (ImageView)rowView.findViewById(R.id.ivDG);

        tvWeek.setText("week "+currentWeek.getWeeks());
        tvDG.setText(currentWeek.getDg());
        ivImage.setImageResource(R.drawable.dg);
        return rowView;
    }
}
