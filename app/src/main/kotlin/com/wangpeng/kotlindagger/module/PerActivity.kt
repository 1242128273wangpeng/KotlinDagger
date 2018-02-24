package com.wangpeng.kotlindagger.module

import java.lang.annotation.Documented
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by wangpeng on 2018/2/24.
 */
@Documented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
