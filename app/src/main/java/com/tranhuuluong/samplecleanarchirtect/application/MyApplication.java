package com.tranhuuluong.samplecleanarchirtect.application;

import android.app.Application;

import com.tranhuuluong.samplecleanarchirtect.di.component.AppComponent;
import com.tranhuuluong.samplecleanarchirtect.di.component.DaggerAppComponent;
import com.tranhuuluong.samplecleanarchirtect.di.module.AppModule;


/**
 * Created by Admin on 1/24/18.
 */

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
