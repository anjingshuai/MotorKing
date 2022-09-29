package com.motorcycle.motorking.data;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductItem {
    public int taskId;
    public int taskType;
    public String title;
    public String description;
    public String thumbUrl;
//    public ParamsInfo paramsInfo;
    public long taskTimeLength;
    public int rewardCount;
    public boolean hasStats;
    public int takeFlag;
    public int cardType;
    public String gameId;
    public String downloadUrl;

    public ProductItem(JSONObject jo) throws JSONException {
        taskId = jo.optInt("taskId");
        taskType = jo.optInt("taskType");
        title = jo.optString("title");
        description = jo.optString("description");
        thumbUrl = jo.optString("thumbUrl");
        taskTimeLength = jo.optLong("taskTimeLength");
        rewardCount = jo.optInt("rewardCount");
        hasStats = jo.optBoolean("hasStats");
        takeFlag = jo.optInt("takeFlag");
        cardType = jo.optInt("cardType");
        gameId = jo.optString("gameId");
        downloadUrl = jo.optString("downloadUrl");

//        JSONObject params = jo.optJSONObject("params");
//        if (params != null) {
//            paramsInfo = new ParamsInfo(params);
//        }
    }

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("taskId", taskId);
            jo.put("taskType", taskType);
            jo.put("taskTimeLength", taskTimeLength);
            jo.put("title", title);
            jo.put("description", description);
            jo.put("thumbUrl", thumbUrl);
            jo.put("rewardCount", rewardCount);
            jo.put("hasStats", hasStats);
            jo.put("takeFlag", takeFlag);
            jo.put("cardType", cardType);
            jo.put("gameId", gameId);
            jo.put("downloadUrl", downloadUrl);
//            jo.put("params", paramsInfo.toJSONObject());
        } catch (Exception e) {
            Log.e("libt.GameListModel", "GameListModel.InnerItem toJsonString() error " + e.toString());
        }

        String result = jo.toString();
        return jo;
    }

    @Override
    public String toString() {
        return "InnerItem{" +
                "taskId=" + taskId +
                ", taskType=" + taskType +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
//                ", paramsInfo=" + paramsInfo +
                ", taskTimeLength=" + taskTimeLength +
                ", rewardCount=" + rewardCount +
                ", hasStats=" + hasStats +
                ", takeFlag=" + takeFlag +
                ", cardType=" + cardType +
                ", gameId=" + gameId +
                ", downloadUrl=" + downloadUrl +
                '}';
    }
}
