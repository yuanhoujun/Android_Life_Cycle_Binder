package me.foji.android.sample;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.foji.lifecyclebinder.LifeCycleBinder;
import me.foji.lifecyclebinder.OnLifeCycleChangedListener;

/**
 * BindedFragment
 *
 * @author Scott Smith 2017-02-27 20:20
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BindedFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LifeCycleBinder.bind(this, new OnLifeCycleChangedListener() {
            @Override
            public void onStart() {
                ToastUtil.toast(getActivity() , BindedFragment.class , "onStart");
            }

            @Override
            public void onStop() {
                ToastUtil.toast(getActivity() , BindedFragment.class , "onStop");
            }

            @Override
            public void onDestroy() {
                ToastUtil.toast(getActivity() , BindedFragment.class , "onDestroy");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_binded , container , false);
    }
}
