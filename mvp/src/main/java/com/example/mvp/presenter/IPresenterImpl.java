package com.example.mvp.presenter;

import com.example.mvp.callback.MyCallBack;
import com.example.mvp.model.IModelImpl;
import com.example.mvp.view.IView;

public class IPresenterImpl {
    IView mIview;
    IModelImpl miModel;
    public IPresenterImpl(IView view){
       mIview = view;
       miModel = new IModelImpl();
    }
    public void startRequest(String url,Class clazz){
        miModel.requestData(url, clazz, new MyCallBack() {
            @Override
            public void setData(Object data) {
                mIview.showResponseData(data);
            }
        });
    }
}
