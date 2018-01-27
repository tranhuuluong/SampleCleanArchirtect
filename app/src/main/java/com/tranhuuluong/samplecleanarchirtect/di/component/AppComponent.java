package com.tranhuuluong.samplecleanarchirtect.di.component;


import com.tranhuuluong.samplecleanarchirtect.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Admin on 1/24/18.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    MainActivityComponent getMainActivityComponent();
}
