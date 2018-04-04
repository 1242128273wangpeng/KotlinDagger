package com.wangpeng.kotlindagger

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangpeng.kotlindagger.repository.RemoteRepository
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/2/28.
 */
class MainFragment : Fragment() {
    @Inject
    lateinit var mRepository: RemoteRepository

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}