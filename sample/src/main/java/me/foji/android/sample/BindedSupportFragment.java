package me.foji.android.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.foji.lifecyclebinder.LifeCycleBinder;
import me.foji.lifecyclebinder.OnLifeCycleChangedListener;

/**
 * BindedSupportFragment
 *
 * @author Scott Smith 2017-02-27 20:20
 */
public class BindedSupportFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LifeCycleBinder.bind(this, new OnLifeCycleChangedListener() {
            @Override
            public void onStart() {
                ToastUtil.toast(getActivity() , BindedSupportFragment.class , "onStart");
            }

            @Override
            public void onStop() {
                ToastUtil.toast(getActivity() , BindedSupportFragment.class , "onStop");
            }

            @Override
            public void onDestroy() {
                ToastUtil.toast(getActivity() , BindedSupportFragment.class , "onDestroy");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_binded_support , container , false);
    }
}
