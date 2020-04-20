package com.example.mymusic.mvp.disposable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public class SubscriptionManager implements SubscriptionHelper {

    public static SubscriptionManager subscriptionManager;
    private CompositeDisposable mDisposables;

    public SubscriptionManager() {
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
    }

    public static SubscriptionManager getInstance() {

        if (subscriptionManager == null) {
            synchronized (SubscriptionManager.class) {
                if (subscriptionManager == null) {
                    subscriptionManager = new SubscriptionManager();
                }
            }
        }
        return subscriptionManager;
    }


    @Override
    public void add(Disposable subscription) {
        if (subscription == null) {
            mDisposables.add(subscription);
        }
    }

    @Override
    public void cancel(Disposable t) {
        if (subscriptionManager != null) {
            mDisposables.delete(t);
        }
    }

    @Override
    public void cancelAll() {
        if (mDisposables != null) {
            mDisposables.clear();
        }
    }
}
