package com.wushujun.brant.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

/**
 * Created by brant on 2017/5/3.
 */

@AVClassName("Forum")
public class ForumModel extends AVObject {

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public AVFile getCover() {
        return getAVFile("cover");
    }

    public void setCover(AVFile cover) {
        put("cover", cover);
    }
}
