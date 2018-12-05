package com.example.mvp.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.mvp.bean.JavaBean;
import com.example.mvp.callback.MyCallBack;
import com.example.mvp.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;

public class IModelImpl implements Imodel {

    private MyCallBack callBack;
     private NetUtil util = new NetUtil();
    @SuppressLint("StaticFieldLeak")
    @Override
    public void requestData(final String url, final Class clazz, final MyCallBack callBack) {
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                return gson(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callBack.setData(o);
            }
        }.execute(url);
    }
    public <T>T gson(String url,Class clazz){
        String data = util.getData(url);
        return  (T) new Gson().fromJson(data,clazz);
    }
}
