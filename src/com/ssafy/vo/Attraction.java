package com.ssafy.vo;

public class Attraction implements Comparable<Attraction>{

    String contentID;
    String contentTypeID;
    String title;
    String address;
    String tel;
    String firstImage;
    String sidoCode;
    String latitude;
    String longitude;
    String overview;

    int views;

    public Attraction(String contentID, String contentTypeID, String title, String address,
        String tel,
        String firstImage, String sidoCode, String latitude, String longitude, String overview) {
        this.contentID = contentID;
        this.contentTypeID = contentTypeID;
        this.title = title;
        this.address = address;
        this.tel = tel;
        this.firstImage = ! firstImage.equals("") ? firstImage:"https://www.muskersbroughtonhall.com.au/wp-content/plugins/ninja-forms/assets/img/no-image-available-icon-6.jpg";
        this.sidoCode = sidoCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.overview = overview;
        this.views=0;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getContentTypeID() {
        return contentTypeID;
    }

    public void setContentTypeID(String contentTypeID) {
        this.contentTypeID = contentTypeID;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getSidoCode() {
        return sidoCode;
    }

    public void setSidoCode(String sidoCode) {
        this.sidoCode = sidoCode;
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
            "contentID='" + contentID + '\'' +
            ", contentTypeID='" + contentTypeID + '\'' +
            ", title='" + title + '\'' +
            ", address='" + address + '\'' +
            ", tel='" + tel + '\'' +
            ", firstImage='" + firstImage + '\'' +
            ", sidoCode='" + sidoCode + '\'' +
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
