package com.example.dee.listviewpractice;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dee on 18/03/2017.
 */

class CustomAdapter extends ArrayAdapter<Days>{
    private ArrayList<Days> dayData;
    public CustomAdapter( Context context, ArrayList<Days> data) {
        super(context, R.layout.custom_row, data);
        dayData = data;
    }

    ///Layout of strings

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false); // creates the row

        String dayName = dayData.get(position).getDays();
        TextView textView = (TextView)customView.findViewById(R.id.textViewList);
        ImageView imageView = (ImageView)customView.findViewById(R.id.listicons);

        textView.setText(dayName);
        imageView.setImageResource(R.mipmap.ic_launcher);
        return customView;
    }
}
