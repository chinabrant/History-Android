package com.wushujun.brant.history;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import  com.wushujun.brant.fragment.*;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ForumHomeFragment mForumHomeFragment;
    private MineFragment mMineFragment;
//
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            hideFragments(transaction);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (mForumHomeFragment == null) {
                        mForumHomeFragment = new ForumHomeFragment();
                        transaction.add(R.id.content, mForumHomeFragment);
                    }
                    else {
                        transaction.show(mForumHomeFragment);
                    }

                    transaction.commit();

                    return true;

                case R.id.navigation_notifications:

                    if (mMineFragment == null) {
                        mMineFragment = MineFragment.newInstance();
                        transaction.add(R.id.content, mMineFragment);
                    }
                    else {
                        transaction.show(mMineFragment);
                    }

                    transaction.commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigation_home);
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        mForumHomeFragment = new ForumHomeFragment();
        ft.replace(R.id.content, mForumHomeFragment);
    }

    // 隐藏所有的fragment
    private void hideFragments(FragmentTransaction ft) {
        if (mForumHomeFragment != null) {
            ft.hide(mForumHomeFragment);
        }

        if (mMineFragment != null) {
            ft.hide(mMineFragment);
        }
    }
}
