package com.wxzeng.sunnyweather.logic.network

import com.wxzeng.sunnyweather.SunnyWeatherApplication
import com.wxzeng.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: 服务器api接口
 * @version:1.0
 */
interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}