package me.foji.lifecyclebinder;

import android.app.Activity;
import android.app.Fragment;

/**
 * 当{@link android.app.Activity} 或 {@link android.app.Fragment} 或
 * {@link android.support.v4.app.Fragment}生命周期发生改变的时候，会调用该事件监听器进入相应的生命周期回调。
 *
 * @author Scott Smith 2017-02-27 18:08
 */
public interface OnLifeCycleChangedListener {
    /**
     * 对应{@link Activity#onStart()} 和 {@link Fragment#onStart()} 和
     * {@link android.support.v4.app.Fragment#onStart()}
     */
    void onStart();
    /**
     * 对应{@link Activity#onStop()} 和 {@link Fragment#onStop()} 和
     * {@link android.support.v4.app.Fragment#onStop()}
     */
    void onStop();
    /**
     * 对应{@link Activity#onDestroy()} 和 {@link Fragment#onDestroy()} 和
     * {@link android.support.v4.app.Fragment#onDestroy()}
     */
    void onDestroy();
}
