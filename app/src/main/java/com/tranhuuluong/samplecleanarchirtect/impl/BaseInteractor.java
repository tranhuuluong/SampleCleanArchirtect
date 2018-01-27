package com.tranhuuluong.samplecleanarchirtect.impl;

import com.tranhuuluong.samplecleanarchirtect.executors.Executors;

import java.util.concurrent.Executor;

/**
 * Created by Admin on 1/25/18.
 */

public abstract class BaseInteractor {
    private Executor workerExecutor;
    private Executor callbackExecutor;

    public BaseInteractor() {
        this(Executors.worker(), Executors.mainThread());
    }

    public BaseInteractor(Executor workerExecutor, Executor callbackExecutor) {
        this.workerExecutor = workerExecutor;
        this.callbackExecutor = callbackExecutor;
        if (workerExecutor == null) {
            throw new IllegalArgumentException("Worker executor cannot be null");
        }

        if (callbackExecutor == null) {
            throw new IllegalArgumentException("Callback executor cannot be null");
        }
    }

    protected void submitTask(Runnable taskRunable) {
        workerExecutor.execute(taskRunable);
    }

    protected void notifyCallback(Runnable callbackRunnable) {
        callbackExecutor.execute(callbackRunnable);
    }
}
