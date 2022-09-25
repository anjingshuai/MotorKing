package com.motorcycle.motorking.fragment;

import android.view.View;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.base.BaseFragment;

public class MerchantFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "MerchantFragment";

    public static MerchantFragment newInstance() {
        return new MerchantFragment();
    }

    @Override
    protected void initView(View parent) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_merchant;
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
