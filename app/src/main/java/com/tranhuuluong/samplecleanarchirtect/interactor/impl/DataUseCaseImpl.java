package com.tranhuuluong.samplecleanarchirtect.interactor.impl;


import com.tranhuuluong.samplecleanarchirtect.data.RetrofitServices;
import com.tranhuuluong.samplecleanarchirtect.interactor.DataUseCase;
import com.tranhuuluong.samplecleanarchirtect.model.Data;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Admin on 1/25/18.
 */

public class DataUseCaseImpl extends BaseInteractor implements DataUseCase {
    private RetrofitServices retrofitServices;

    public DataUseCaseImpl(RetrofitServices retrofitServices) {
        this.retrofitServices = retrofitServices;
    }

    @Override
    public void getData(final OnDataRetrievedListener listener) {
        submitTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Call<Data> dataCall = retrofitServices.getDatafromApi();
                    Response<Data> dataResponse = dataCall.execute();
                    if (dataResponse.isSuccessful() && dataResponse.body() != null) {
                        notifyResult(dataResponse.body(), null, listener);
                    } else {
                        throw new Exception(dataResponse.errorBody().toString());
                    }

                } catch (Exception e) {
                    notifyResult(null, e, listener);
                }
            }
        });
    }

    private void notifyResult(final Data data, final Exception e, final OnDataRetrievedListener listener) {
        notifyCallback(new Runnable() {
            @Override
            public void run() {
                listener.onDataRetrieved(data, e);
            }
        });
    }
}
