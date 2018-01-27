package com.tranhuuluong.samplecleanarchirtect.presenter.impl;

import com.tranhuuluong.samplecleanarchirtect.presenter.BasePresenter;
import javax.annotation.Nullable;

/**
 * Created by Admin on 1/25/18.
 */

public class BasePresenterImpl<V> implements BasePresenter<V> {
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Nullable
    public V getView() {
        if (view == null) {
            throw new NullPointerException("View reference is null. Have you call attachView(View v) ?");
        }
        return view;
    }
}
