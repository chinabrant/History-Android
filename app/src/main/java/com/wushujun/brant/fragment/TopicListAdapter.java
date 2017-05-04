package com.wushujun.brant.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wushujun.brant.history.R;
import com.wushujun.brant.model.TopicModel;

import java.util.List;


public class TopicListAdapter extends BaseAdapter {

    private final List<TopicModel> mData;
    private final LayoutInflater mInflater;

    public TopicListAdapter(List<TopicModel> items, Context context) {
        mData = items;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return mData.size();
    }

    @Override
    public TopicModel getItem(int position) {

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

            convertView = mInflater.inflate(R.layout.topic_list_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            viewHolder.mItem = getItem(position);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setmItem(getItem(position));

        // 判断是否有封面图
        if (position == 1 || position == 3 || position == 8) {
            // 没有图片，隐藏
            viewHolder.mCoverImageView.setVisibility(View.GONE);
        }
        else {
            viewHolder.mCoverImageView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    public class ViewHolder {
        public final View mView;
        public TextView mTitleTextView;      // 标题
        public ImageView mCoverImageView;     // 封面
        public ImageView mAvatarImageView;    // 用户头像
        public TextView mNickTextView;       // 用户昵称
        public TextView mContentTextView;    // 内容缩略
        public TextView mTimeTextView;       // 时间
        public TopicModel mItem;

        public ViewHolder(View view) {
            mView = view;

            mTitleTextView = (TextView) view.findViewById(R.id.topic_list_title);
            mCoverImageView = (ImageView) view.findViewById(R.id.topic_list_cover);
            mNickTextView = (TextView) view.findViewById(R.id.topic_list_nick);
            mTimeTextView = (TextView) view.findViewById(R.id.topic_list_time);
            mAvatarImageView = (ImageView) view.findViewById(R.id.topic_list_avatar);

        }

        public void setmItem(TopicModel model) {
            mItem = model;

            mTitleTextView.setText(model.getTitle());
            mNickTextView.setText((String) model.getUser().get("nick"));
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }
}
