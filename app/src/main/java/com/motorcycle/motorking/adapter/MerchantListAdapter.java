package com.motorcycle.motorking.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.motorcycle.motorking.R;
import com.motorcycle.motorking.model.MerchantModel;

import java.util.ArrayList;

public class MerchantListAdapter extends RecyclerView.Adapter<MerchantListAdapter.ViewHolder> {

    private static final String TAG = "GameAdapter";

    private ArrayList<MerchantModel> mList;

    public MerchantListAdapter(ArrayList<MerchantModel> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_merchant_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvDistance;
        private TextView tvCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvDistance = itemView.findViewById(R.id.tv_distance);
            tvCategory = itemView.findViewById(R.id.tv_category);
        }

        public void bindData(MerchantModel model, int pos) {
            tvName.setText(model.getName());
            tvAddress.setText(model.getAddress());
            tvDistance.setText(model.getDistance());
            tvCategory.setText(model.getServiceCategory());

            itemView.setOnClickListener(v -> {
                openMerchantDetailPage(model, pos);
            });
        }

        private void openMerchantDetailPage(MerchantModel model, int pos) {
            Intent intent = new Intent();
//            intent.setClass(itemView.getContext(), MerchantDetailActivity.class);
            itemView.getContext().startActivity(intent);
        }
    }

}
