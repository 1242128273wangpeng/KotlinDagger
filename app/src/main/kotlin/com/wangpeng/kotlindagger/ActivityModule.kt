package com.wangpeng.kotlindagger

import android.app.Activity
import android.content.Context
import com.wangpeng.kotlindagger.module.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by wangpeng on 2018/2/24.
 */
@Module
class ActivityModule(var activity: Activity) {

    @Provides
    @PerActivity
    fun provideActivity(): Activity {
        return activity;
    }

    @Provides
    @PerActivity
    fun provideContext(): Context {
        return activity
    }
}