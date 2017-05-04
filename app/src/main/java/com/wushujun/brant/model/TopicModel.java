package com.wushujun.brant.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brant on 2017/5/3.
 */

@AVClassName("Topic")
public class TopicModel extends AVObject {
    public TopicModel() {

    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public void setContent(String content) {
        put("content", content);
    }

    public String getContent() {
        return getString("content");
    }

    public List getImages() {
        return getList("images");
    }

    public void setImages(List images) {
        put("images", images);
    }

    public AVObject getForum() {
        return getAVObject("forum");
    }

    public void setForum(AVObject forum) {
        put("forum", forum);
    }

    public  Boolean getIsHidden() {
        return getBoolean("isHidden");
    }

    public void setIsHidden(Boolean isHidden) {
        put("isHidden", isHidden);
    }

    public void setRecommend(Boolean recommend) {
        put("isRecommend", recommend);
    }

    public Boolean getRecommend() {
        return  getBoolean("isRecommend");
    }

    public AVUser getUser() { return getAVUser("user"); }

    public void setUser(AVUser user) { put("user", user); }

}
