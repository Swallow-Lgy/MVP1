package com.example.loagin.view.presenter;

import android.text.TextUtils;

import com.example.loagin.view.model.Bean;
import com.example.loagin.view.model.NetUtil;
import com.example.loagin.view.model.UserBean;
import com.example.loagin.view.view.IView;

public class LoaginPresenter {
    private String loginUrl="http://120.27.23.105/user/login?mobile=%s&password=%s";
    private String zhuceUrl="http://120.27.23.105/user/reg?mobile=%s&password=%s";
    IView mIview;

    public LoaginPresenter(IView view){
      mIview=view;

    }
    //登录

     public void denglu(Bean bean){
        NetUtil.getData(String.format(loginUrl, bean.getUsername(), bean.getPassword()), UserBean.class, new NetUtil.CallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean cc) {
                if (cc.getMsg().equals("登录成功")){
                    mIview.success("");
                }
                else {
                    mIview.fail("登录失败");
                }
            }
        });

     }
     //注册
   public void zhuce(Bean bean){
        NetUtil.getData(String.format(zhuceUrl, bean.getUsername(), bean.getPassword()), UserBean.class, new NetUtil.CallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean bean) {
                if (bean.getMsg().equals("注册成功")){
                     mIview.success("");
                }
                else {
                    mIview.fail("注册失败");
                }
            }
        });
   }
   public void des(){
        mIview=null;
   }

}
