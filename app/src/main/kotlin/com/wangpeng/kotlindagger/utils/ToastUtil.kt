package com.wangpeng.kotlindagger.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by wangpeng on 2018/2/24.
 */
class ToastUtil(var context: Context) {
    fun show(content: String): Unit {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }
}