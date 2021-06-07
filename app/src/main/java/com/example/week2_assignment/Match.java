package com.example.week2_assignment;

public class Match
{
    private String name;
    private String imageUrl;
    private boolean liked;

    public float longi;
    public float lat;

    public Match(){}

    public Match(String name, String imageUrl, boolean liked, float longi, float lat)
    {
        this.name = name;
        this.imageUrl = imageUrl;
        this.liked = liked;
        this.longi = longi;
        this.lat = lat;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public void setLiked(boolean liked)
    {
        this.liked = liked;
    }

    public String getName()
    {
        return name;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public boolean getLiked()
    {
        return liked;
    }

    public void setLongi(float longi)
    {
        this.longi = longi;
    }

    public float getLongi()
    {
        return this.longi;
    }

    public void setLat(float lat)
    {
        this.lat = lat;
    }

    public float getLat()
    {
        return this.lat;
    }
}
