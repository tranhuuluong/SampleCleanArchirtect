package com.tranhuuluong.samplecleanarchirtect.presenter.impl;


import com.tranhuuluong.samplecleanarchirtect.data.RetrofitServices;
import com.tranhuuluong.samplecleanarchirtect.model.Data;
import com.tranhuuluong.samplecleanarchirtect.presenter.MainPresenter;
import com.tranhuuluong.samplecleanarchirtect.view.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 1/25/18.
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {
    private RetrofitServices retrofitServices;

    public MainPresenterImpl(RetrofitServices retrofitServices) {
        this.retrofitServices = retrofitServices;
    }

    @Override
    public void getData() {
        retrofitServices.getDatafromApi().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful() && response.body() != null) {
                    getView().displayData(response.body());
                } else {
                    getView().showError();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                getView().showError();
            }
        });
    }
}
