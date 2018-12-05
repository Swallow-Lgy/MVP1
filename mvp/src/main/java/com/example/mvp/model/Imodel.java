package com.example.mvp.model;

import com.example.mvp.callback.MyCallBack;

public interface Imodel {
         void requestData(String url, Class clazz, MyCallBack callBack);
}
