package com.wixpress.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class PriceCalculator {
    public static final String OM = "OM", DH = "DH", LP = "LP";

    public static final String SMALL = "S", MEDIUM = "M", LARGE = "L";

    public static final String OM_S = "1";
    public static final String OM_L = "7.20";
    public static final String DH_S = "0.90";
    public static final String DH_M = "3.40";
    public static final String LP_S = "1.23";
    public static final String LP_M = "3";
    public static final String LP_L = "7";

    public String getPrice(String transaction) {
        String provider = transaction.substring(13, 15);
        String size = transaction.substring(11, 12);
        String price = "ERROR";

        if (isValidDate(transaction)) {
            price = getPrice(provider, size);
        }
        transaction += " " + price;
        return transaction;
    }

    private boolean isValidDate(String order) {
        String date = order.substring(0, 10);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        format.setLenient(false);

        try {
            format.parse(date);
        }
        catch (ParseException e) {
            return false;
        }
        return true;
    }

    private String getPrice(String provider, String size) {
        if (provider.equals(OM)) {
            if (size.equals(SMALL)) return OM_S;
            if (size.equals(LARGE)) return OM_L;
        }
        if (provider.equals(DH)) {
            if (size.equals(SMALL)) return DH_S;
            if (size.equals(MEDIUM)) return DH_M;
        }
        if (provider.equals(LP)) {
            if (size.equals(SMALL)) return LP_S;
            if (size.equals(MEDIUM)) return LP_M;
            if (size.equals(LARGE)) return LP_L;
        }
        return "ERROR";
    }
}
