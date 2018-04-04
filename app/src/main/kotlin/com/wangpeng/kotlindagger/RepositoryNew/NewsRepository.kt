package com.wangpeng.kotlindagger.RepositoryNew

import com.wangpeng.kotlindagger.bean.BaseData
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/3/7.
 */
interface NewsRepository {
    fun newsList(): Observable<BaseData>
    fun newDetails(q:String):Observable<BaseData>

    class Source @Inject constructor(private val dataSourceFactory:NewsSource.Factory):NewsRepository{
        override fun newsList(): Observable<BaseData> = dataSourceFactory.network().newsList()

        override fun newDetails(q: String): Observable<BaseData> = dataSourceFactory.network().newDetails(q)
    }

}