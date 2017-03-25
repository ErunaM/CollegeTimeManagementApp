package com.example.dee.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private MyDBHandler dba;
    private Days days;
    private ArrayList<Days> dbDays = new ArrayList<>();
    private CustomAdapter dayAdapter;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview = (ListView)findViewById(R.id.jadeListView);

        refreshData();

    }
    private void refreshData() {

        dbDays.clear();
        dba = new MyDBHandler(getApplicationContext());

        ArrayList<Days> DaysFromDB = dba.getDays();


        for(int i = 0; i < DaysFromDB.size(); i++)
        {
            String name = DaysFromDB.get(i).getDays();
            String mainAssignment = DaysFromDB.get(i).getMainAssignment();

            days = new Days();
            days.setDays(name);
            days.setMainAssignment(mainAssignment);
            dbDays.add(days);
        }
        dba.close();

        //Setup adapter
        dayAdapter = new CustomAdapter(getApplicationContext(),dbDays);
        listview.setAdapter(dayAdapter);

    }

}
