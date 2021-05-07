package com.bidding;

public class Bidding {
    private String name;
    private String info;
    private boolean read;
    private String link;

    public Bidding(String name, String info, String link, boolean read) {
        this.name = name;
        this.info = info;
        this.read = read;
        this.link = link;
    }

    public Bidding(){}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
