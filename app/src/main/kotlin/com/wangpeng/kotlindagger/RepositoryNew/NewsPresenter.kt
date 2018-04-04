package com.wangpeng.kotlindagger.RepositoryNew

import com.wangpeng.kotlindagger.bean.BaseData
import com.wangpeng.kotlindagger.framework.interactor.UseCaseObserver
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/3/7.
 */
class NewsPresenter @Inject constructor(private val getNews: GetNews) {
    internal lateinit var newsView: NewsView

    fun destory() {
        getNews.dispose()
        newsView.dispose()
    }

    fun loadMovies() {
        newsView.showLoading()
        getNews.execute(NewsObserver())
    }

    internal inner class NewsObserver : UseCaseObserver<BaseData>() {

    }

}