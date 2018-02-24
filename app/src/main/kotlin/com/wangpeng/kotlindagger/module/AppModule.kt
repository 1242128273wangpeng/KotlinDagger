package com.wangpeng.kotlindagger.module

import android.content.Context
import android.content.SharedPreferences
import com.wangpeng.kotlindagger.MyApplication
import com.wangpeng.kotlindagger.utils.ToastUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wangpeng on 2018/1/22.
 */
@Module(includes = arrayOf(NetModule::class, RepositoryModule::class))
class AppModule(var mApplication: MyApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return mApplication
    }

    @Provides
    @Singleton
    fun provideToastUtil(context: Context): ToastUtil {
        return ToastUtil(context)
    }

    @Provides
    @Singleton
    fun provideSP(context: Context): SharedPreferences {
        return context.getSharedPreferences("config", Context.MODE_PRIVATE)
    }
}