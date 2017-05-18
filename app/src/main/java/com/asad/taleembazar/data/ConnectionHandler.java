package com.asad.taleembazar.data;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asad on 5/18/17.
 */

public class ConnectionHandler {
    private String mUrl="";
    public String getJsonfromUrl() {
        try {
        URL Url = new URL(mUrl);
        HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        line = sb.toString();
        connection.disconnect();
        is.close();
        sb.delete(0, sb.length());
        return line;
    } catch (Exception e) {
        return null;
    }
}
    }