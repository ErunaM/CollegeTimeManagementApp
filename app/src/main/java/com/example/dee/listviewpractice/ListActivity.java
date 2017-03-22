package com.example.dee.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private MyDBHandler dba;
    private Days myFood;
    private ArrayList<Days> dbDays = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);




        // adapter to convert my string[] to list items
        //ListAdapter listAdapter = new CustomAdapter(this, foods);
        ListView listView = (ListView)findViewById(R.id.jadeListView);
        //listView.setAdapter(listAdapter);

    }

}
