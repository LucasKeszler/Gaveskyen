package org.example.oenskeskyen.Models;

public class Wish {
    private int id;
    private String title;
    private String description;
    private String link;
    private String icon;
    private int userId;

    public Wish(int id, String title, String description, String link, String icon, int userId) {
        this.description = description;
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.link = link;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Wish (String title, String description, String link, String icon, int userId) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.icon = icon;
        this.userId = userId;
    }
}
