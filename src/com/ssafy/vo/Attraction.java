package com.ssafy.vo;

public class Attraction implements Comparable<Attraction>{

    String title;
    String address;
    String latitude;
    String longitude;
    String overview;

    int views;

    public Attraction(String title, String address, String latitude, String longitude, String overview) {

        this.title = title;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.overview = overview;
        this.views=0;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Attraction{" +
            ", title='" + title + '\'' +
            ", address='" + address + '\'' +
            ", latitude='" + latitude + '\'' +
            ", longitude='" + longitude + '\'' +
            ", overview='" + overview + '\'' +
            '}';
    }

    @Override
    public int compareTo(Attraction o) {
        if(this.views > o.views) {
            return 1;
        }
        // 자기 자신의 views와 o의 views가 같다면 0
        else if(this.views == o.views) {
            return 0;
        }
        // 자기 자신의 views가 o의 views보다 작다면 음수
        else {
            return -1;
        }
    }
}
