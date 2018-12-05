package com.example.loagin.view.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loagin.R;
import com.example.loagin.view.model.Bean;
import com.example.loagin.view.presenter.LoaginPresenter;

public class MvpTwoActivity extends AppCompatActivity implements View.OnClickListener,IView {
    EditText name,psw;
    LoaginPresenter mloaginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_two);
        initView();
        mloaginPresenter = new LoaginPresenter(this);
    }

    private void initView() {
        name = findViewById(R.id.name);
        psw  = findViewById(R.id.psw);
        findViewById(R.id.reg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.reg:
                Bean bean = new Bean(name.getText().toString(),psw.getText().toString());
                 mloaginPresenter.zhuce(bean);
                 break;
                 default:
                     break;
        }
    }

    @Override
    public void success(Object data) {
        Intent intent = new Intent(this,MvpOneActivity.class);
        startActivity(intent);
    }

    @Override
    public void fail(String msg) {
        Toast.makeText(MvpTwoActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
