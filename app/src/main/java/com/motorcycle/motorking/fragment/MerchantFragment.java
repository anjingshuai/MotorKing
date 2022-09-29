package com.motorcycle.motorking.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.adapter.MerchantListAdapter;
import com.motorcycle.motorking.base.BaseFragment;
import com.motorcycle.motorking.model.MerchantModel;

import java.util.ArrayList;

public class MerchantFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = "MerchantFragment";

    private RecyclerView recyclerView;
    private MerchantListAdapter merchantListAdapter;

    public static MerchantFragment newInstance() {
        return new MerchantFragment();
    }

    @Override
    protected void initView(View parent) {
        recyclerView = parent.findViewById(R.id.rv_container);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_merchant;
    }

    @Override
    protected void initData() {
        initMerchantList();
    }

    private void initMerchantList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        merchantListAdapter = new MerchantListAdapter(getMerchantList());
        recyclerView.setAdapter(merchantListAdapter);
    }

    private ArrayList<MerchantModel> getMerchantList() {
        ArrayList<MerchantModel> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new MerchantModel("川崎旗舰店","海淀区西二旗大街30号","3.5Km", "川崎系列", 5));
            list.add(new MerchantModel("道达尔加油站","朝阳区望京街道与四纬路交叉口路南","2.1KM", "92、95、98汽油，柴油", 4.8));
            list.add(new MerchantModel("小伟机车维修保养","海淀区西三旗","9.2KM", "各种摩托车维修、保养", 4.9));
            list.add(new MerchantModel("豪爵专卖店","昌平区京藏高速辅路65号101","22.1KM", "豪爵系列、铃木系列摩托车售卖", 4.8));
            list.add(new MerchantModel("高档摩托售后店","海淀区软件园路92号","3.9KM", "摩托售后保养服务", 4.8));
        }

        return list;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
    }
}
