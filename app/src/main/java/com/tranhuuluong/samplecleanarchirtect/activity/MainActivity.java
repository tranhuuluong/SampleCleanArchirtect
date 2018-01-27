package com.tranhuuluong.samplecleanarchirtect.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tranhuuluong.samplecleanarchirtect.R;
import com.tranhuuluong.samplecleanarchirtect.application.MyApplication;
import com.tranhuuluong.samplecleanarchirtect.model.Data;
import com.tranhuuluong.samplecleanarchirtect.presenter.MainPresenter;
import com.tranhuuluong.samplecleanarchirtect.view.MainView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) this.getApplication()).getAppComponent()
                .getMainActivityComponent()
                .inject(this);
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
