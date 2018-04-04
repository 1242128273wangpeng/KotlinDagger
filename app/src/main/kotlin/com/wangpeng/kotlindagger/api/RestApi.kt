package com.wangpeng.kotlindagger.api

import com.wangpeng.kotlindagger.bean.BaseData
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by wangpeng on 2018/3/7.
 */
@Singleton
class RestApi
@Inject constructor(retrofit: Retrofit) : ApiService {

    private val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override fun getQueryLists(q: String): Observable<BaseData> {
        return apiService.getQueryLists(q)
    }

    override fun getWordLists(): Observable<BaseData> {
        return apiService.getWordLists()
    }

}