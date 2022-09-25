package com.motorcycle.motorking.fragment;

import android.view.View;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.base.BaseFragment;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "MeFragment";

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    protected void initView(View parent) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initData() {
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
    }
}
