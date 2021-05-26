package com.example.week2_assignment;

public class Match
{
    private String name;
    private String imageUrl;
    private boolean liked;

    public Match(){}

    public Match(String name, String imageUrl, boolean liked)
    {
        this.name = name;
        this.imageUrl = imageUrl;
        this.liked = liked;
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
}
