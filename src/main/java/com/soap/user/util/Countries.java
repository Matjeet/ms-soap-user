package com.soap.user.util;

import static com.soap.user.util.Constants.COL_PREFIX;

public enum Countries {
    COLOMBIA(COL_PREFIX),
    DEFAULT(COL_PREFIX);

    private final String prefix;

    Countries(String prefix){
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static String getCompleteCellphone(String country, String cellphone) {
        try {
            return valueOf(country.toUpperCase()).getPrefix() + cellphone;
        } catch (IllegalArgumentException e) {
            return DEFAULT.getPrefix() + cellphone;
        }
    }
}
