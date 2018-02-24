package com.wangpeng.kotlindagger.module

import com.wangpeng.kotlindagger.common.NetManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wangpeng on 2018/2/24.
 */
@Module
class NetModule {
    @Provides
    @Singleton
    fun provideNetManager(): NetManager? {
        return NetManager.getInstance()
    }
}