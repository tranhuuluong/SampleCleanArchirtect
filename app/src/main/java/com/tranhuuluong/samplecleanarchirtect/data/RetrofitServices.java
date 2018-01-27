package com.tranhuuluong.samplecleanarchirtect.data;


import com.tranhuuluong.samplecleanarchirtect.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Admin on 1/24/18.
 */

public interface RetrofitServices {

    @GET("/api/users?page=2")
    Call<Data> getDatafromApi();
}
