package me.foji.android.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * BindedFragmentActivity
 *
 * @author Scott Smith 2017-02-27 20:19
 */
public class BindedSupportFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binded_support_fragment);
    }
}
