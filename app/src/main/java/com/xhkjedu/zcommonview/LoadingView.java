package com.xhkjedu.zcommonview;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Create by zac on 2019/6/3
 */
public class LoadingView {
    private LoadingFragment mLoadingView;
    private FragmentActivity mActivity;

    public LoadingView(FragmentActivity activity) {
        mActivity = activity;
    }


    public LoadingView init() {
        mLoadingView = new LoadingFragment();
        return this;
    }

    public LoadingView show() {
        FragmentManager manager = mActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_loading_container, mLoadingView);
        transaction.commit();

        return this;
    }

    public LoadingView remove() {
        FragmentManager manager = mActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(mLoadingView);
        transaction.commit();

        return this;
    }
}

