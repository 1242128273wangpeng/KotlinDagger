package com.wangpeng.kotlindagger.api

import com.wangpeng.kotlindagger.bean.BaseData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wangpeng on 2018/1/22.
 */
interface ApiService {
    @GET("query")
    fun getQueryLists(@Query("q") q: String): Observable<BaseData>

    @GET("words")
    fun getWordLists(): Observable<BaseData>
}