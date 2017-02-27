package me.foji.android.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.foji.lifecyclebinder.LifeCycleBinder;
import me.foji.lifecyclebinder.OnLifeCycleChangedListener;

/**
 * BindedActivity
 *
 * @author Scott Smith 2017-02-27 20:18
 */
public class BindedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeCycleBinder.bind(this, new OnLifeCycleChangedListener() {
            @Override
            public void onStart() {
                ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onStart");
            }

            @Override
            public void onStop() {
                ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onStop");
            }

            @Override
            public void onDestroy() {
                ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onDestroy");
            }
        });
    }
}
