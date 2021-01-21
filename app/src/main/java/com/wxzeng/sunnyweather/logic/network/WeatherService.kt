package com.wxzeng.sunnyweather.logic.network


import com.wxzeng.sunnyweather.SunnyWeatherApplication
import com.wxzeng.sunnyweather.logic.model.DailyResponse
import com.wxzeng.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/01/20 3:04 PM
 *  @desc:
 *  @version:
 */
interface WeatherService{

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat:String):
            Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

}