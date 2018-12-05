package com.example.mvp.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.bean.JavaBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdpter extends BaseAdapter {
    private Context context;
    private List<JavaBean.PostsBean> mData;

    public MyBaseAdpter(Context context) {
        this.context = context;
        mData = new ArrayList<>();
    }

    public void setmData(List<JavaBean.PostsBean> data) {
        mData.clear();
        if (data!=null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }
    public void addData(List<JavaBean.PostsBean> data){
        if (data!=null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public JavaBean.PostsBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView = View.inflate(context,R.layout.item,null);
           holder.icon =  convertView.findViewById(R.id.icon);
           holder.textView = convertView.findViewById(R.id.title);
           convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mData.get(position).getTitle());
        ImageLoader.getInstance().displayImage(mData.get(position).getCustom_fields().getThumb_c().get(0),holder.icon);
        return convertView;
    }
    class ViewHolder{
        ImageView icon;
        TextView textView;
    }
}
