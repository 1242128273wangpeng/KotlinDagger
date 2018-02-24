package com.wangpeng.kotlindagger

import android.app.Application
import com.wangpeng.kotlindagger.module.AppModule
import com.wangpeng.kotlindagger.module.NetModule

/**
 * Created by wangpeng on 2018/1/22.
 */
class MyApplication : Application() {
    private lateinit var mAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this@MyApplication)).build()
    }

    fun getAppComponent(): AppComponent {
        return mAppComponent;
    }
}