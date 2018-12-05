package com.example.dell.mvp1.presemter;

import android.text.TextUtils;

import com.example.dell.mvp1.model.NetUtil;
import com.example.dell.mvp1.model.User;
import com.example.dell.mvp1.view.Iview;

public class LoaginPresenter {
    //实例化Iview
    private Iview miview;
    public LoaginPresenter(Iview iview){
        miview = iview;
    }
    public void submit(User user){
        if (checkName(user.getUsername())&&checkPw(user.getPassword())){
            boolean loginApi = NetUtil.loginApi(user);
            if (loginApi){
                //
                miview.success("");
            }
            else {
                miview.fail("失败");
            }
        }
        else {
            miview.fail("用户密码错误");
        }
    }
    public void detachView(){
        miview=null;
    }
    private boolean checkName(String name){
         return !TextUtils.isEmpty(name);
    }
    private boolean checkPw(String pw){
        return  (!TextUtils.isEmpty(pw)&&pw.length()>=6);
    }
}
