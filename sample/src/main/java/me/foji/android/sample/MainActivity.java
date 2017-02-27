package me.foji.android.sample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void go(Class<? extends Activity> cls) {
        Intent intent = new Intent(this , cls);
        startActivity(intent);
    }

    @OnClick(R.id.btn_bind_activity)
    public void bindActivity() {
        go(BindedActivity.class);
    }

    @OnClick(R.id.btn_bind_fragment)
    public void bindFragment() {
        go(BindedFragmentActivity.class);
    }

    @OnClick(R.id.btn_bind_support_fragment)
    public void bindSupportFragment() {
        go(BindedSupportFragmentActivity.class);
    }
}
