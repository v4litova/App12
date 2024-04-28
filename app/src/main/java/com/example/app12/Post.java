package com.example.app12;

public class Post {
    private String id;
    private String name;
    private String author;
    public Post(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


}

