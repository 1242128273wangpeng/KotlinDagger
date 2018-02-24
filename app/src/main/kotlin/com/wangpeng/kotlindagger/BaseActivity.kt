package com.wangpeng.kotlindagger

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by wangpeng on 2018/2/24.
 */
open class BaseActivity : AppCompatActivity() {
    protected var mActivityComponent: ActivityComponent? = null

    protected fun getActivityComponent(): ActivityComponent? {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .appComponent(getAppComponent())
                    .activityModule(ActivityModule(this@BaseActivity))
                    .build()
        }
        return mActivityComponent
    }

    protected fun getAppComponent(): AppComponent {
        return (application as MyApplication).getAppComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}