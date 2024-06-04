package com.example.movieapp;

public class Film {
    private String image;
    private String title;
    private String description;
    private String genre;
    private String price;
    private String rating;
    private String time;

    public Film() {

    }
    public Film(String image, String imdb, String minutes, String title, String description, String price) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public String getTime() {
        return time;
    }
}

