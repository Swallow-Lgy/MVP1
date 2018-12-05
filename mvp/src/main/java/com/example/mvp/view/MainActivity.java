package com.example.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mvp.R;
import com.example.mvp.adpter.MyBaseAdpter;
import com.example.mvp.bean.JavaBean;
import com.example.mvp.presenter.IPresenterImpl;

import java.util.List;

import me.maxwin.view.XListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private IPresenterImpl miPresenter;
    private String url = "http://i.jandan.net/?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status," +
            "custom_fields&page=1&custom_fields=thumb_c,views&dev=1 ";
     int page=1;
    private XListView xListView;
    private MyBaseAdpter myBaseAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = findViewById(R.id.xlist);
        miPresenter = new IPresenterImpl(this);
        myBaseAdpter = new MyBaseAdpter(this);
        xListView.setAdapter(myBaseAdpter);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                starRequest();
            }

            @Override
            public void onLoadMore() {
               starRequest();
            }
        });
        starRequest();
    }


    @Override
    public void onClick(View v) {

    }
    public void starRequest(){
        miPresenter.startRequest(url,JavaBean.class);
    }
    @Override
    public void showResponseData(Object data) {
        JavaBean postsBean= (JavaBean) data;
           if (page==1){
           myBaseAdpter.setmData(postsBean.getPosts());
       }
       else {
           myBaseAdpter.addData(postsBean.getPosts());
       }
        page++;
       xListView.stopLoadMore();
       xListView.stopRefresh();
    }
}
