package com.wangpeng.kotlindagger

import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.wangpeng.kotlindagger.adapter.NewsAdapter
import com.wangpeng.kotlindagger.api.ApiService
import com.wangpeng.kotlindagger.bean.BaseData
import com.wangpeng.kotlindagger.common.NetManager
import com.wangpeng.kotlindagger.module.AppModule
import com.wangpeng.kotlindagger.repository.RemoteRepository
import com.wangpeng.kotlindagger.repository.RemoteRepository_Factory
import com.wangpeng.kotlindagger.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    internal lateinit var mRepository: RemoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent()?.inject(this@MainActivity)
        var recyclerview: RecyclerView = findViewById(R.id.recyclerview)
        mRepository.getApiServer().getWordLists().doOnSubscribe { t ->
            Log.i("MainActivity", "doOnSubscribe:" + t.toString())
        }?.doOnNext { t ->
            Log.i("MainActivity", "doOnNext:" + t.toString())
        }?.doOnError { e ->
            Log.i("MainActivity", "doOnError:" + e.toString())
        }?.doOnComplete {
            Log.i("MainActivity", "doOnComplete")
        }?.observeOn(AndroidSchedulers.mainThread())?.subscribeOn(Schedulers.io())?.subscribe(object : Consumer<BaseData> {
            override fun accept(t: BaseData) {
                Log.i("MainActivity", "subscribe:" + t.toString() + "  thread-->" + Thread.currentThread().name)
                val list: List<String> = t.result as List<String>
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerview.addItemDecoration(SpaceItemDecoration(3))
                recyclerview.adapter = NewsAdapter(list, this@MainActivity)
                getAppComponent().toastUtil().show("显示列表")
            }
        })
    }

    internal inner class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            if (parent.getChildPosition(view) != 0)
                outRect.top = space
        }
    }

}
