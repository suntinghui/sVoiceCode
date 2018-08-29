package com.sth.vc.util;

import okhttp3.MediaType;

public class Contains {

    public static final String HOST = "http://111.231.220.219:8999";

    public static final MediaType getJSONType() {
        return MediaType.parse("application/json;charset=utf-8");
    }

}
