package com.tranhuuluong.samplecleanarchirtect.di.component;


import com.tranhuuluong.samplecleanarchirtect.activity.MainActivity;
import com.tranhuuluong.samplecleanarchirtect.di.Activity;
import com.tranhuuluong.samplecleanarchirtect.di.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by Admin on 1/24/18.
 */

@Subcomponent(modules = MainActivityModule.class)
@Activity
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
