package com.motorcycle.motorking.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.motorcycle.motorking.R;
import com.motorcycle.motorking.data.ProductItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    public static final String PORTAL_MAIN_GAME = "main_game";
    public static final String PORTAL_MAIN_HISTORY = "main_history";
    public static final String PORTAL_ME_HISTORY = "me_history";

    private static final String TAG = "ProductAdapter";

    private ArrayList<ProductItem> list;
    private int itemWidth;
    protected String mPortal;

    public enum PageType {
        MAIN_GAME("main_game"), MAIN_HISTORY("main_history"), ME_HISTORY("me_history"), NEW("new");

        private String mValue;

        PageType(String value) {
            mValue = value;
        }

        public String getValue() {
            return mValue;
        }
    }

    protected PageType mContentType;

    public ProductAdapter(ArrayList<ProductItem> list) {
        this(list, PORTAL_MAIN_GAME, PageType.MAIN_GAME);
    }

    public ProductAdapter(ArrayList<ProductItem> list, String portal, PageType contentType) {
        this.list = list;
        mPortal = portal;
        mContentType = contentType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_item, parent, false);
        return new ViewHolder(view, itemWidth, mContentType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(list.get(position), position, mPortal);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private PageType mContentType;
        private ImageView ivThumb;
        private TextView tvName;

        public ViewHolder(@NonNull View itemView, int itemWidth, PageType contentType) {
            super(itemView);
            initView();
            if (itemWidth > 0) {
                setViewWidth(itemView, itemWidth);
            }
            mContentType = contentType;
        }

        private void initView() {
            ivThumb = itemView.findViewById(R.id.iv_thumb);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindData(ProductItem model, int pos, String portal) {
            if (model == null
                    || TextUtils.isEmpty(model.downloadUrl)) {
                itemView.setVisibility(View.GONE);
                Log.e(TAG, "ProductItem is not invalid!");
                return;
            }

            Glide.with(ivThumb)
                    .load(cover2Https(model.thumbUrl))
                    .placeholder(R.drawable.default_avatar)
                    .error(R.drawable.default_avatar)
                    .transform(new CenterCrop())
                    .into(ivThumb);

            tvName.setText(model.title);

            itemView.setOnClickListener(v -> {
                if (isClickTooFrequently(v)) return;
                openGame(model, pos, portal);
            });

            // 游戏展示事件
            if (!model.hasStats) {
                model.hasStats = true;
                String posStr = (pos / 2 + 1) + "_" + (pos % 2 + 1);
                statsGameShowed(posStr, String.valueOf(model.taskId), String.valueOf(model.gameId));
            }
        }

        private void openGame(ProductItem model, int pos, String portal) {
            //TODO by libt, open product detail
//            H5Router.turn2H5GamePage(
//                    model.downloadUrl,
//                    model.gameId,
//                    model.taskId,
//                    model.rewardCount,
//                    model.taskTimeLength, portal);

//            HistoryHelper.addPlayedGame(model, portal);
            // 游戏点击事件
            String posStr = (pos / 2 + 1) + "_" + (pos % 2 + 1);
            statsGameClicked(posStr, String.valueOf(model.taskId), String.valueOf(model.gameId));
        }

        private String getPagePve() {
//            if (mContentType == MainGamePage.PageType.MAIN_GAME) {
//                return "home";
//            } else if (mContentType == MainGamePage.PageType.MAIN_HISTORY || mContentType == MainGamePage.PageType.ME_HISTORY) {
//                return "history";
//            } else
                return "home";
        }

        private void statsGameShowed(String pos, String taskId, String gameId) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("position_id", pos);
            hashMap.put("task_id", taskId);
            hashMap.put("game_id", gameId);
            String pveCur = String.format("%s/game_area/x", getPagePve());
//            GameStats.collectShowVeEvent(pveCur, hashMap);
        }

        private void statsGameClicked(String pos, String taskId, String gameId) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("position_id", pos);
            hashMap.put("task_id", taskId);
            hashMap.put("game_id", gameId);
            String pveCur = String.format("%s/game_area/x", getPagePve());
//            GameStats.collectClickVeEvent(pveCur, null, hashMap);
        }

    }

    public static String cover2Https(String url) {
        if (TextUtils.isEmpty(url)) return url;
        return url.replace("http:", "https:");
    }

    public static void setViewWidth(View target, int width) {
        ViewGroup.LayoutParams targetLP = target.getLayoutParams();
        targetLP.width = width;
        target.setLayoutParams(targetLP);
    }

    public static boolean isClickTooFrequently(View v) {
        return isClickTooFrequently(v, 1000L);
    }

    private static final int b_click_frequently_tag = 0x289018;
    public static boolean isClickTooFrequently(View v, long intervalTime) {
        try {
            Object tag = v.getTag(b_click_frequently_tag);
            long past = tag == null ? 0L : (Long)tag;
            long now = System.currentTimeMillis();
            long interval = now - past;
            if (Math.abs(interval) < intervalTime) {
                return true;
            }

            v.setTag(b_click_frequently_tag, now);
        } catch (Exception var10) {
        }

        return false;
    }

}
