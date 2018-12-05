package com.example.dell.mvp1.model;

import android.os.SystemClock;

public class NetUtil {
    public static boolean loginApi(User user){
        SystemClock.sleep(2000);
        if (user.getUsername().equals("lgy")&&user.getPassword().equals("123456")){
            return true;
        }
        return false;
    }
}
