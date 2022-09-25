package com.motorcycle.motorking.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public abstract class BaseFragment extends Fragment {

    private final ArrayList<String> keys = new ArrayList<>();

    protected Fragment mCurFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addChangedListenerKey(keys);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void initView(View parent);

    protected abstract void initData();

    /**
     * 添加需要监听的回调key
     **/
    protected void addChangedListenerKey(ArrayList<String> keys) {

    }

    /**
     * 切换fragment
     **/
    protected void switchTab(@IdRes int layoutId, Fragment from, Fragment to, String tag) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (from == null) {
            if (fm.findFragmentByTag(tag) == null && !to.isAdded()) {
                transaction.add(layoutId, to, tag);
            }
        } else {
            if (fm.findFragmentByTag(tag) == null && !to.isAdded()) {
                transaction.hide(from).add(layoutId, to, tag);
            } else {
                transaction.hide(from).show(to);
            }
        }
        mCurFragment = to;
        transaction.commitAllowingStateLoss();
    }

}
