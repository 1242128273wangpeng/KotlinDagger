package com.wangpeng.kotlindagger

import android.content.Context
import com.wangpeng.kotlindagger.module.ActivityContext
import com.wangpeng.kotlindagger.module.ApplicationContext
import com.wangpeng.kotlindagger.module.PerActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangpeng on 2018/2/24.
 */
@PerActivity
@Component(modules = arrayOf(ActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {

    fun inject(mMainActivity: MainActivity)
}