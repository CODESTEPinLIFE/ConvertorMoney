package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class URLConnect {
    public Document getURLConnect() throws IOException {
        String URL = "https://finance.rambler.ru/currencies/USD/";
        Document document = Jsoup.parse(new URL(URL),5000);
        return document;
    }

}
