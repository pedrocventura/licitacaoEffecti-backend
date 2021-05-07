package com.bidding;

import com.bidding.Crawler.CrawlerIFC;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
@RestController
public class BiddingApplication {

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }

    public Gson gson = new Gson();

    public static void main(String[] args) {
        SpringApplication.run(BiddingApplication.class, args);
    }

    @GetMapping("/")
    public String listBidding(@RequestParam(value = "page", defaultValue = "1") Integer value) throws IOException {
        CrawlerIFC crawler = new CrawlerIFC(value);
        return gson.toJson(crawler.getBiddings());
    }

    @PostMapping("/setRead")
    public void setRead(String json) throws IOException {
            Bidding bidding = gson.fromJson(json,Bidding.class);
            bidding.setRead(!bidding.getRead());
    }
}
