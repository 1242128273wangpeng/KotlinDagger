package com.wangpeng.kotlindagger.RepositoryNew

import com.wangpeng.kotlindagger.bean.BaseData
import com.wangpeng.kotlindagger.framework.executor.ExecutionScheduler
import com.wangpeng.kotlindagger.framework.interactor.UseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/3/7.
 */
class GetNews @Inject constructor(private val newsRepository: NewsRepository, private val scheduler: ExecutionScheduler): UseCase<BaseData, UseCase.None>() {
    override fun buildObservable(params: None?): Observable<BaseData> = newsRepository.newsList().compose(scheduler.applyHighPriorityScheduler())
}