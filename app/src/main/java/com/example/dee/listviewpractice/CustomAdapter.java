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
/**
 * Created by Dee on 18/03/2017.
 */

class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter( Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    ///Layout of strings

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false); // creates the row

        String singleFoodItem = getItem(position);
        TextView textView = (TextView)customView.findViewById(R.id.textViewList);
        ImageView imageView = (ImageView)customView.findViewById(R.id.listicons);

        textView.setText(singleFoodItem);
        imageView.setImageResource(R.mipmap.ic_launcher);
        return customView;
    }
}
