package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    public static String USD = null;
    public static String EUR = null;

    public static String getUSD() {
        return USD;
    }

    private static URLConnect urlConnect;
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");
    private static String pullMoney(String data) throws Exception {
        Matcher matcher = pattern.matcher(data);
        if(matcher.find()){
            return matcher.group();
        }
        throw new  Exception("not found");
    }
    public Parse(URLConnect urlConnect){
        this.urlConnect = urlConnect;
    }
    public   String USDParse(){
        try {
            Document page =  urlConnect.getURLConnect();
            Element tableWithMoney = page.select("div[class=finance-exchange-rate__data]").first();
            String moneyHTML = tableWithMoney.select("div[class=finance-exchange-rate__value]").text();
            USD = pullMoney(moneyHTML);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return USD;
    }
    public static  void EURParse(){
        try {
            Document page =  urlConnect.getURLConnect();
            Element tableWithMoney = page.select("div[class=finance-exchange-rate__data]").first();
            String moneyHTML = tableWithMoney.select("div[class=finance-exchange-rate__value]").text();
            EUR = pullMoney(moneyHTML);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
