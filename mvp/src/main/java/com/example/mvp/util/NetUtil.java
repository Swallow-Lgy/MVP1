package com.example.mvp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {
    public String getData(String mUrl){
        try {
            URL url = new URL(mUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode==200){
                String result = strream2String(urlConnection.getInputStream());
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String strream2String(InputStream is) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        for (String tmp = br.readLine(); tmp!=null;tmp = br.readLine()){
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }
}
