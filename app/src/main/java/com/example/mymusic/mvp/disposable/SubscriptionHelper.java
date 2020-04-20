package com.example.mymusic.mvp.disposable;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public interface SubscriptionHelper {
    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelAll();
}
