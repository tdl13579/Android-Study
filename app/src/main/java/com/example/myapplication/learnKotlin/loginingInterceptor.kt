package com.example.myapplication.learnKotlin

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer

class loginingInterceptor:Interceptor {
    val TAG:String = "loginingInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
        val timeStart  = System.nanoTime()
        val request = chain.request()
        val response = chain.proceed(request)
        val buffer = Buffer()
        val requestBody = buffer.readUtf8()
        Log.e(TAG, "intercept: "+String.format("发送时间",request.url,requestBody) )
    }
}