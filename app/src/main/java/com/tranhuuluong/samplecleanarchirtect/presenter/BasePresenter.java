package com.tranhuuluong.samplecleanarchirtect.presenter;

/**
 * Created by Admin on 1/25/18.
 */

public interface BasePresenter<V> {
    void attachView(V view);
    void detachView();
}
