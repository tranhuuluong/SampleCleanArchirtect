package com.tranhuuluong.samplecleanarchirtect.presenter.impl;


import com.tranhuuluong.samplecleanarchirtect.interactor.DataUseCase;
import com.tranhuuluong.samplecleanarchirtect.model.Data;
import com.tranhuuluong.samplecleanarchirtect.presenter.MainPresenter;
import com.tranhuuluong.samplecleanarchirtect.view.MainView;

/**
 * Created by Admin on 1/25/18.
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {
    private DataUseCase dataUseCase;

    public MainPresenterImpl(DataUseCase dataUseCase) {
        this.dataUseCase = dataUseCase;
    }

    @Override
    public void getData() {
        dataUseCase.getData(new DataUseCase.OnDataRetrievedListener() {
            @Override
            public void onDataRetrieved(Data data, Exception e) {
                if (e == null) {
                    getView().displayData(data);
                } else {
                    getView().showError();
                }
            }
        });
    }
}
