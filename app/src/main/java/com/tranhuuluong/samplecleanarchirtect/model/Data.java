package com.tranhuuluong.samplecleanarchirtect.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 1/23/18.
 */

public class Data {
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("total")
    @Expose
    private int total;

    @Override
    public String toString() {
        return "page : " + page + "\n"
                + "per_page : " + perPage + "\n"
                + "total : " + total;
    }
}
