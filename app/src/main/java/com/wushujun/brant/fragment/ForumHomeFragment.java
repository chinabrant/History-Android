package com.wushujun.brant.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.*;
import com.wushujun.brant.history.R;
import com.wushujun.brant.history.TopicDetailActivity;
import com.wushujun.brant.model.TopicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brant on 2017/5/2.
 */

public class ForumHomeFragment extends Fragment {

    private ListView mListView;
    private List<TopicModel> mListData;
    private TopicListAdapter mAdapter;

    // List view的点击事件
    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("点击了" + position);
            Toast.makeText(getActivity(), "点击了" + position, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.setClass(getActivity(), TopicDetailActivity.class);
            getActivity().startActivity(intent);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListData = new ArrayList<TopicModel>();
        mAdapter = new TopicListAdapter(mListData, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // 加载view
        View view = inflater.inflate(R.layout.fragment_forum_home, container, false);
        mListView = (ListView) view.findViewById(R.id.forum_home_list);
        // 设置点击事件监听
        mListView.setOnItemClickListener(mItemClickListener);
        // 设置adapter
        mListView.setAdapter(mAdapter);

        queryTopicList();

        return view;
    }



    private void queryTopicList() {

        AVQuery<TopicModel> query = AVObject.getQuery(TopicModel.class);
        query.limit(10);
        query.include("user.nick");
        query.findInBackground(new FindCallback<TopicModel>() {
            @Override
            public void done(List<TopicModel> results, AVException e) {
                if (results != null) {
                    mListData.addAll(results);
//                    mListView.notify();
                    mAdapter.notifyDataSetChanged();
                    System.out.println("results: " + results);
                }
            }
        });
    }
}
