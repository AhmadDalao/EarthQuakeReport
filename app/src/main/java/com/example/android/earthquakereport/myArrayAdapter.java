package com.example.android.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class myArrayAdapter extends ArrayAdapter<earthQuakeModel> {

    private String primaryLocation;
    private String locationOffset;
    private static final String LOCATION_SEPARATOR = " of ";


    public myArrayAdapter(Context context, ArrayList<earthQuakeModel> earthQuakeModels) {
        super(context, 0, earthQuakeModels);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItems = convertView;
        if (listItems == null) {
            listItems = LayoutInflater.from(this.getContext()).inflate(R.layout.custom_list, parent, false);
        }


        earthQuakeModel currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listItems.findViewById(R.id.magnitude);
        magnitude.setText(String.valueOf(currentEarthquake.getMagnitude()));


        String originalLocation = currentEarthquake.getPlaceName();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        TextView primaryLocationView = (TextView) listItems.findViewById(R.id.placeName);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItems.findViewById(R.id.nearByPlace);
        locationOffsetView.setText(locationOffset);


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItems.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItems.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        return listItems;

    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}
