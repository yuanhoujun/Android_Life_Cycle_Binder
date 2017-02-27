package me.foji.lifecyclebinder;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * 使用该类完成对{@link Fragment}的生命周期绑定
 *
 * @author Scott Smith 2017-02-27 18:31
 */
@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class LifeCycleFragment extends Fragment {
    private OnLifeCycleChangedListener onLifeCycleChangedListener;

    public LifeCycleFragment() {}

    @SuppressLint("ValidFragment")
    public LifeCycleFragment(OnLifeCycleChangedListener onLifeCycleChangedListener) {
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
