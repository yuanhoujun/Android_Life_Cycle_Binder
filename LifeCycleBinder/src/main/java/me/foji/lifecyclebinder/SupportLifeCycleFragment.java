package me.foji.lifecyclebinder;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;

/**
 * 使用该类完成对{@link Fragment}的生命周期绑定
 *
 * @author Scott Smith 2017-02-27 19:24
 */
public class SupportLifeCycleFragment extends Fragment {
    private OnLifeCycleChangedListener onLifeCycleChangedListener;

    public SupportLifeCycleFragment() {}

    @SuppressLint("ValidFragment")
    public SupportLifeCycleFragment(OnLifeCycleChangedListener onLifeCycleChangedListener) {
        this.onLifeCycleChangedListener = onLifeCycleChangedListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(null != onLifeCycleChangedListener) {
            onLifeCycleChangedListener.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(null != onLifeCycleChangedListener) {
            onLifeCycleChangedListener.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null != onLifeCycleChangedListener) {
            onLifeCycleChangedListener.onDestroy();
        }
    }
}
