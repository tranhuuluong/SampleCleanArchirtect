package com.tranhuuluong.samplecleanarchirtect.di.module;


import com.tranhuuluong.samplecleanarchirtect.data.RetrofitServices;
import com.tranhuuluong.samplecleanarchirtect.di.Activity;
import com.tranhuuluong.samplecleanarchirtect.interactor.DataUseCase;
import com.tranhuuluong.samplecleanarchirtect.interactor.impl.DataUseCaseImpl;
import com.tranhuuluong.samplecleanarchirtect.presenter.MainPresenter;
import com.tranhuuluong.samplecleanarchirtect.presenter.impl.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 1/24/18.
 */

@Module
public class MainActivityModule {
    @Provides
    @Activity
    DataUseCase providesDataUseCase(RetrofitServices retrofitServices) {
        return new DataUseCaseImpl(retrofitServices);
    }

    @Provides
    @Activity
    MainPresenter providesMainPresenter(DataUseCase dataUseCase) {
        return new MainPresenterImpl(dataUseCase);
    }
}
