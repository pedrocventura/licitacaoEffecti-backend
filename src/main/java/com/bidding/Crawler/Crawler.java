package com.bidding.Crawler;

import com.bidding.Bidding;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Crawler {

    protected ArrayList<Bidding> biddings;

    Document getData(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public ArrayList getBiddings() {
        return this.biddings;
    }

    protected void setBiddings(ArrayList<Bidding> biddings) {
        this.biddings = biddings;
    }

}
