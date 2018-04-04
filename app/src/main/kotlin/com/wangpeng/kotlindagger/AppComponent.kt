package com.wangpeng.kotlindagger

import android.content.Context
import android.content.SharedPreferences
import com.wangpeng.kotlindagger.module.AppModule
import com.wangpeng.kotlindagger.module.ApplicationContext
import com.wangpeng.kotlindagger.utils.ToastUtil
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangpeng on 2018/1/22.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun appContext(): Context

    fun toastUtil(): ToastUtil

    fun sharedPreferences(): SharedPreferences
}