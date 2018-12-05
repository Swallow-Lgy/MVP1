package com.example.loagin.view.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loagin.R;
import com.example.loagin.view.model.Bean;
import com.example.loagin.view.model.UserBean;
import com.example.loagin.view.presenter.LoaginPresenter;

public class MvpOneActivity extends AppCompatActivity implements View.OnClickListener,IView {
     EditText username,password;
     LoaginPresenter mloaginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_one);
        initView();
        initPrensenter();
    }

    private void initPrensenter() {
        mloaginPresenter = new LoaginPresenter(this);
    }

    private void initView() {
      username = findViewById(R.id.username);
      password = findViewById(R.id.password);
      password.invalidate();
      findViewById(R.id.login).setOnClickListener(this);
      findViewById(R.id.zhuce).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          int id = v.getId();
          switch (id){
              case R.id.login:
                  Bean bean = new Bean(username.getText().toString(),password.getText().toString());
                  mloaginPresenter.denglu(bean);
                  break;
              case R.id.zhuce:
                  Intent intent = new Intent(MvpOneActivity.this,MvpTwoActivity.class);
                  startActivity(intent);
                  break;
                  default:
                      break;
          }
    }

    @Override
    public void success(Object data) {
        Intent intent  = new Intent(MvpOneActivity.this,LoaginActivity.class);
        startActivity(intent);
    }

    @Override
    public void fail(String msg) {
        Toast.makeText(MvpOneActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mloaginPresenter=null;
    }
}
