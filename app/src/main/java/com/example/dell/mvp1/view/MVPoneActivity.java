package com.example.dell.mvp1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.mvp1.R;
import com.example.dell.mvp1.model.User;
import com.example.dell.mvp1.presemter.LoaginPresenter;

import java.net.URL;

public class MVPoneActivity extends AppCompatActivity implements View.OnClickListener,Iview {
    LoaginPresenter mloaginPresenter;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpone);
        initPresenter();
        initView();
    }
     private void initPresenter(){
        mloaginPresenter = new LoaginPresenter(this) ;
     }
     private void initView(){
         username = findViewById(R.id.username);
         password = findViewById(R.id.password);
         password.invalidate();
         findViewById(R.id.login).setOnClickListener(this);
     }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login:
                User user = new User(username.getText().toString(),password.getText().toString());
                mloaginPresenter.submit(user);
                break;
                default:
                    break;
        }
    }

    @Override
    public void success(Object data) {
        Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mloaginPresenter=null;
    }
}
