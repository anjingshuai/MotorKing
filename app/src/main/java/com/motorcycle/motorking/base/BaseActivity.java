package com.motorcycle.motorking.base;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseActivity extends FragmentActivity{

    protected Fragment mCurFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected abstract @IdRes int getContainerId();

    protected abstract @LayoutRes int getLayoutId();

    /**
     * 切换fragment
     **/
    protected void switchTab(Fragment from, Fragment to, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (from == null) {
            if (fm.findFragmentByTag(tag) == null && !to.isAdded()) {
                transaction.add(getContainerId(), to, tag);
            }
        } else {
            if (fm.findFragmentByTag(tag) == null && !to.isAdded()) {
                transaction.hide(from).add(getContainerId(), to, tag);
            } else {
                transaction.hide(from).show(to);
            }
        }
        mCurFragment = to;
        transaction.commitAllowingStateLoss();
    }

}
