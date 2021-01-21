package com.wxzeng.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: 网络数据源入口
 * @version:1.0
 */
object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun getRealtimeWeather(lng:String,lat:String) =
            weatherService.getRealtimeWeather(lng,lat).await()

    suspend fun getDailyWeather(lng:String,lat:String) =
        weatherService.getDailyWeather(lng,lat).await()

    private suspend fun<T> Call<T>.await():T{
        return suspendCoroutine {continuation->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>,response: Response<T>){
                    val body = response.body()
                    if(body!= null)continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}