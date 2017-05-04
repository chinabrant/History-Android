package com.wushujun.brant.app;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.wushujun.brant.model.ForumModel;
import com.wushujun.brant.model.TopicModel;

/**
 * Created by brant on 2017/5/3.
 */

public class XiuShuiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化 LeanCloud
        AVObject.registerSubclass(TopicModel.class);
        AVObject.registerSubclass(ForumModel.class);
        AVOSCloud.initialize(this,"6bBA0I1KVGoDkHlak9Xn2aLF-gzGzoHsz","HN0Y5vTuaJGuDSqdRVUBspJs");
    }
}
