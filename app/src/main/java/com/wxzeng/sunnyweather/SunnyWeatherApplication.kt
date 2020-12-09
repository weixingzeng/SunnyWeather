package com.wxzeng.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: Application
 * @version: 1.0
 */
class SunnyWeatherApplication :Application() {
    companion object{
        const val TOKEN = ""
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context =applicationContext
    }
}