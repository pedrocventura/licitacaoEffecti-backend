package com.bidding.Crawler;

import com.bidding.Bidding;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlerIFC extends Crawler implements CrawlerInterface{

    private String url = "http://www.ifc-riodosul.edu.br/site/dap/category/licitacoes";
    private Document doc;
    public CrawlerIFC(Integer page) throws IOException {
        if(page == 1){
            this.doc = this.getData(this.url);
        }else {
            this.url = this.url + "/page/"+page.toString();
            this.doc = this.getData(this.url);
        }
        this.setBiddings();
    }

    @Override
    public void setBiddings() throws IOException {
        this.biddings = this.findBinddings();
    }


    private ArrayList<Bidding> findBinddings(){
        ArrayList<Bidding> biddings = new ArrayList<Bidding>();
        ArrayList<Element> biddingBodies  = this.doc.getElementsByClass("media-body");

        for(Element body : biddingBodies){
            String name = body.getElementsByTag("a").get(0).text();
            String link = body.getElementsByTag("a").get(0).attr("href");
            String info = body.getElementsByClass("info").get(0).text();

            Bidding el = new Bidding(name, info,link,false);
            biddings.add(el);
        }
        return biddings;
    }
}
