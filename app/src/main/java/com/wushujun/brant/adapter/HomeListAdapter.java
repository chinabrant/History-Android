package com.wushujun.brant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wushujun.brant.history.R;

import java.util.List;

/**
 * Created by brant on 2017/5/3.
 */

public class HomeListAdapter extends BaseAdapter {

    // list数据
    private List<String> mData;
    // 用来读取布局文件
    private LayoutInflater mInflater;

    public HomeListAdapter(List<String> data, Context context) {
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.topic_list_item_layout, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.topic_list_title);
            viewHolder.cover = (ImageView) convertView.findViewById(R.id.topic_list_cover);
            viewHolder.nick = (TextView) convertView.findViewById(R.id.topic_list_nick);
            viewHolder.time = (TextView) convertView.findViewById(R.id.topic_list_time);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.topic_list_avatar);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 判断是否有封面图
        if (position == 1 || position == 3 || position == 8) {
            // 没有图片，隐藏
            viewHolder.cover.setVisibility(View.GONE);
        }
        else {
            viewHolder.cover.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    public class ViewHolder {
        public TextView title;      // 标题
        public ImageView cover;     // 封面
        public ImageView avatar;    // 用户头像
        public TextView nick;       // 用户昵称
        public TextView content;    // 内容缩略
        public TextView time;       // 时间
    }
}
