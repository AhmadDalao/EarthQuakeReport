package com.example.android.earthquakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<earthQuakeModel> quakeModels = QueryUtils.extractEarthquakes();
//        quakeModels.add(new earthQuakeModel(7.5, "San francisco", "Feb 2, 2016"));
//        quakeModels.add(new earthQuakeModel(6.1, "London", "July 20,2015"));
//        quakeModels.add(new earthQuakeModel(7.5, "San francisco", "Feb 2, 2016"));
//        quakeModels.add(new earthQuakeModel(6.1, "London", "July 20,2015"));
//        quakeModels.add(new earthQuakeModel(7.5, "San francisco", "Feb 2, 2016"));
//        quakeModels.add(new earthQuakeModel(6.1, "London", "July 20,2015"));
//        quakeModels.add(new earthQuakeModel(7.5, "San francisco", "Feb 2, 2016"));
//        quakeModels.add(new earthQuakeModel(6.1, "London", "July 20,2015"));

        myArrayAdapter adapter = new myArrayAdapter(this, quakeModels);
        ListView listView = (ListView) findViewById(R.id.myList);
        listView.setAdapter(adapter);


    }
}
