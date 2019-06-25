package com.example.android.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class myArrayAdapter extends ArrayAdapter<earthQuakeModel> {
    public myArrayAdapter(Context context, ArrayList<earthQuakeModel> earthQuakeModels) {
        super(context, 0, earthQuakeModels);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItems = convertView;
        if (listItems == null) {
            listItems = LayoutInflater.from(this.getContext()).inflate(R.layout.custom_list, parent, false);
        }


        earthQuakeModel quakeModel = getItem(position);

        TextView magnitude = (TextView) listItems.findViewById(R.id.magnitude);
        magnitude.setText(String.valueOf(quakeModel.getMagnitude()));


        TextView placeName = (TextView) listItems.findViewById(R.id.placeName);
        placeName.setText(quakeModel.getPlaceName());

        TextView date = (TextView) listItems.findViewById(R.id.date);
        date.setText(quakeModel.getDate());


        return listItems;

    }
}
