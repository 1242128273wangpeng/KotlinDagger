package com.wangpeng.kotlindagger.module

import com.wangpeng.kotlindagger.repository.RemoteRepository
import com.wangpeng.kotlindagger.repository.Repository
import dagger.Binds
import dagger.Module

/**
 * Created by wangpeng on 2018/2/24.
 */
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repository: RemoteRepository): Repository
}