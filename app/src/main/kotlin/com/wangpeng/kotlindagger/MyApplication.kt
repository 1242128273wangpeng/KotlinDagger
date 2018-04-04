package com.wangpeng.kotlindagger

import android.app.Application
import com.wangpeng.kotlindagger.module.AppModule
import com.wangpeng.kotlindagger.module.NetModule

/**
 * Created by wangpeng on 2018/1/22.
 */
class MyApplication : Application() {

    val mAppComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder().appModule(AppModule(this@MyApplication)).build()
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() = mAppComponent.inject(this)

    fun getAppComponent(): AppComponent {
        return mAppComponent;
    }

}