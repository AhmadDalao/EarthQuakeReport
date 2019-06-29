package com.example.android.earthquakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<earthQuakeModel> quakeModels = QueryUtils.extractEarthquakes();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Find the current earthquake that was clicked on
                earthQuakeModel currentEarthquake = quakeModels.get(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);


            }
        });


    }
}
