package com.wangpeng.kotlindagger.repository

import com.wangpeng.kotlindagger.common.NetManager
import com.wangpeng.kotlindagger.api.ApiService
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/2/24.
 */

class RemoteRepository @Inject constructor(var mNetManager: NetManager) : Repository {

    override fun getApiServer(): ApiService {
        return mNetManager.req(ApiService::class.java)
    }

}