package com.example.loagin.view.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {
    public interface  CallBack<T>{
        void onSuccess(T t);
    }
    @SuppressLint("StaticFieldLeak")
    public static void getData(String StrUlr, final Class clazz, final CallBack callBack){
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                return getData(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callBack.onSuccess(o);
            }
        }.execute(StrUlr);
    }
    public static <T> T getData(String StrUrl,Class clazz){
        return (T) new Gson().fromJson(getData(StrUrl),clazz);
    }
    public static String getData(String strurl)  {
        try {
            URL url = new URL(strurl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode==200){
                String result = stream2String(urlConnection.getInputStream());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String stream2String(InputStream is) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        for (String tmp = br.readLine(); tmp!=null;tmp=br.readLine()){
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }
}
