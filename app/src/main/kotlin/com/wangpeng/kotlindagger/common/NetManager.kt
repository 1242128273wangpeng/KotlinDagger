package com.wangpeng.kotlindagger.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wangpeng.kotlindagger.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by wangpeng on 2018/1/22.
 */
class NetManager @Inject constructor() {
    private lateinit var mRetrofit: Retrofit

    init {
        initRetrofit()
    }

    companion object {
        private var mNetManager: NetManager? = null
        fun getInstance(): NetManager? {
            if (mNetManager == null) {
                print("创建NetManager")
                mNetManager = NetManager()
                return mNetManager
            } else {
                print("已经创建NetManager")
                return mNetManager
            }
        }
    }

    fun <T> req(reqServer: Class<T>): T {
        return mRetrofit.create(reqServer)
    }

    private fun initRetrofit() {
        var API_BASE: String = Constant.BASE_URL
        getRefrofit(API_BASE)
    }


    private fun getRefrofit(base: String): Retrofit {
        mRetrofit = Retrofit.Builder()
                .baseUrl(base)
                .client(getOkHttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson())).build()
        return mRetrofit
    }

    private fun getGson(): Gson {
        var gsonBuilder: GsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")
        gsonBuilder.setPrettyPrinting()
        return gsonBuilder.create()
    }

    private fun getOkHttp(): OkHttpClient {
        var logInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(logInterceptor)
        }
        okHttpClientBuilder.addInterceptor(CustomInteceptor())

        return okHttpClientBuilder.connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
    }

    class CustomInteceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response {
            val original: Request = chain?.request()!!
            var httpUrl: HttpUrl = original.url()!!

            var newHttpUrl: HttpUrl = httpUrl.newBuilder().addQueryParameter("key", Constant.APIKEY).build()

            var requestBuilder: Request.Builder = original.newBuilder()?.url(newHttpUrl)!!
            var request: Request = requestBuilder.build()
            return chain.proceed(request);
        }
    }


}