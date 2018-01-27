package com.tranhuuluong.samplecleanarchirtect.di.module;

import android.content.Context;

import com.tranhuuluong.samplecleanarchirtect.application.MyApplication;
import com.tranhuuluong.samplecleanarchirtect.data.RetrofitServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 1/24/18.
 */

@Module
public class AppModule {
    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return application;
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RetrofitServices providesRetrofitServices(Retrofit retrofit) {
        return retrofit.create(RetrofitServices.class);
    }
}
