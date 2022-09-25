package com.motorcycle.motorking.fragment;

import android.annotation.SuppressLint;
import android.view.View;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.base.BaseFragment;

import java.util.ArrayList;

@SuppressLint("NotifyDataSetChanged")
public class HomeTabFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "HomeTabFragment";

//    private final ArrayList<GameListModel.InnerItem> list = new ArrayList<>();

    protected ArrayList<View> mViews = new ArrayList<>();

    protected int mCurrentPageIndex = -1;

    public HomeTabFragment() {
    }

    public static HomeTabFragment newInstance() {
        return new HomeTabFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View parent) {

    }

    @Override
    protected void initData() {
        initPages();
    }

    private void initPages() {
    }

    @Override
    protected void addChangedListenerKey(ArrayList<String> keys) {
        super.addChangedListenerKey(keys);
    }

    @Override
    public void onClick(View v) {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
