package com.wangpeng.kotlindagger.RepositoryNew

import com.wangpeng.kotlindagger.api.RestApi
import com.wangpeng.kotlindagger.bean.BaseData
import io.reactivex.Observable
import javax.inject.Inject
import dagger.Lazy

/**
 * Created by wangpeng on 2018/3/7.
 */
interface NewsSource : NewsRepository {
    class Factory @Inject constructor(val network: Lazy<NetWork>, val disk: Lazy<Disk>) {
        fun network(): NetWork = network.get()
        fun disk(): Disk = disk.get()
    }

    class NetWork @Inject constructor(private val restApi: RestApi) : NewsSource {
        override fun newDetails(q: String): Observable<BaseData> = restApi.getQueryLists(q)

        override fun newsList(): Observable<BaseData> = restApi.getWordLists()
    }


    class Disk @Inject constructor() : NewsSource {
        override fun newsList(): Observable<BaseData> = TODO()

        override fun newDetails(q: String): Observable<BaseData> = TODO()
    }

}