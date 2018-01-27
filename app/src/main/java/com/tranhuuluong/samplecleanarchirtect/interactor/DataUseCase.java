package com.tranhuuluong.samplecleanarchirtect.interactor;


import com.tranhuuluong.samplecleanarchirtect.model.Data;

/**
 * Created by Admin on 1/25/18.
 */

public interface DataUseCase {
    interface OnDataRetrievedListener {
        void onDataRetrieved(Data data, Exception e);
    }
    void getData(OnDataRetrievedListener listener);
}
