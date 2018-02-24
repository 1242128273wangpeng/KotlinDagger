package com.wangpeng.kotlindagger.repository

import com.wangpeng.kotlindagger.api.ApiService

/**
 * Created by wangpeng on 2018/2/24.
 */
interface Repository {
    fun getApiServer(): ApiService
}