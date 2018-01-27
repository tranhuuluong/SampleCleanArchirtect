package com.tranhuuluong.samplecleanarchirtect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tranhuuluong.samplecleanarchirtect.R;
import com.tranhuuluong.samplecleanarchirtect.data.RetrofitClient;
import com.tranhuuluong.samplecleanarchirtect.data.RetrofitServices;
import com.tranhuuluong.samplecleanarchirtect.interactor.DataUseCase;
import com.tranhuuluong.samplecleanarchirtect.interactor.impl.DataUseCaseImpl;
import com.tranhuuluong.samplecleanarchirtect.model.Data;
import com.tranhuuluong.samplecleanarchirtect.presenter.MainPresenter;
import com.tranhuuluong.samplecleanarchirtect.presenter.impl.MainPresenterImpl;
import com.tranhuuluong.samplecleanarchirtect.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitServices retrofitServices = RetrofitClient.getRetrofitClient().create(RetrofitServices.class);
        DataUseCase dataUseCase = new DataUseCaseImpl(retrofitServices);
        MainPresenter presenter = new MainPresenterImpl(dataUseCase);
        presenter.attachView(this);
        presenter.getData();
    }

    @Override
    public void displayData(Data data) {
        Log.d("Data", data.toString());
    }

    @Override
    public void showError() {

    }
}
