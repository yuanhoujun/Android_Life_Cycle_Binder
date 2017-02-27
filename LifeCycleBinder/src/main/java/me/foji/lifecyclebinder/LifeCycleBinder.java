package me.foji.lifecyclebinder;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;

/**
 * LifeCycleBinder旨在提供一个简单的{@link Activity}或{@link Fragment}或
 * {@link android.support.v4.app.Fragment}生命 * 周期绑定实现；
 * 使用该类实现生命周期绑定，无需往工程的Activity或者Fragment中插入代码，是一种简洁的无痛绑定实现方案，特别适合
 * 第三方框架开发中使用；例如：@see <a href='https://github.com/bumptech/glide'>Glide</a>就使用了这种实现
 * 方案，具体使用方法请参照该类API介绍。
 *
 * @author Scott Smith 2017-02-27 18:06
 */
public class LifeCycleBinder {
    private static final String FRAGMENT_TAG = LifeCycleBinder.class.getName();

    /**
     * 绑定{@link Activity}生命周期回调
     *
     * @param activity 绑定生命周期回调的目标Activity
     * @param listener 对应事件监听器
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void bind(Activity activity, OnLifeCycleChangedListener listener) {
        assertActivityDestroyed(activity);

        FragmentManager fragmentManager = activity.getFragmentManager();
        Fragment lifeCycleFragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (null == lifeCycleFragment) {
            lifeCycleFragment = new LifeCycleFragment(listener);
            fragmentManager.beginTransaction().add(lifeCycleFragment, FRAGMENT_TAG)
                    .commitAllowingStateLoss();
        }
    }

    /**
     * 绑定{@link Fragment}生命周期回调
     *
     * @param fragment 绑定生命周期回调的目标Fragment
     * @param listener 对应事件监听器
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void bind(Fragment fragment, OnLifeCycleChangedListener listener) {
        FragmentManager fragmentManager = fragment.getChildFragmentManager();
        Fragment lifeCycleFragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (null == lifeCycleFragment) {
            lifeCycleFragment = new LifeCycleFragment(listener);
            fragmentManager.beginTransaction().add(lifeCycleFragment, FRAGMENT_TAG)
                    .commitAllowingStateLoss();
        }
    }

    /**
     * 绑定{@link Fragment}生命周期回调
     *
     * @param fragment 绑定生命周期回调的目标Fragment
     * @param listener 对应事件监听器
     */
    public static void bind(android.support.v4.app.Fragment fragment,
                            OnLifeCycleChangedListener listener) {
        android.support.v4.app.FragmentManager fragmentManager = fragment.getChildFragmentManager();
        android.support.v4.app.Fragment lifeCycleFragment = fragmentManager
                .findFragmentByTag(FRAGMENT_TAG);

        if (null == lifeCycleFragment) {
            lifeCycleFragment = new SupportLifeCycleFragment(listener);
            fragmentManager.beginTransaction().add(lifeCycleFragment, FRAGMENT_TAG)
                    .commitAllowingStateLoss();
        }
    }

    // 为Activity销毁状态增加断言
    private static void assertActivityDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }
}
