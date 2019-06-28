package com.example.android.earthquakereport;

public class earthQuakeModel {
    private Double magnitude;
    private String placeName;
    private String date;
    private long mTimeInMilliseconds;


    public earthQuakeModel(Double magnitude, String placeName, String date) {
        this.magnitude = magnitude;
        this.placeName = placeName;
        this.date = date;
    }


    public earthQuakeModel(Double magnitude, String placeName, long mTimeInMilliseconds) {
        this.magnitude = magnitude;
        this.placeName = placeName;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
