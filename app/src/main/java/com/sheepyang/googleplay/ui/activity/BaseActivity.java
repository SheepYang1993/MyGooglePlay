package com.sheepyang.googleplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * android-support-v7-appcompat
 * 
 * 支持ActionBar效果, 可以兼容2.x版本, 让2.x也能够展示Actionbar效果
 * 
 * 1. 引入appcompat
 * 2. 解决support-v4冲突问题
 * 3. 继承ActionBarActivity
 * 
 * @author Kevin
 * @date 2015-10-27
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setLogo(R.drawable.ic_launcher);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
    }
}
