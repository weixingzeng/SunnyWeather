package com.wxzeng.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName


/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/01/20 2:39 PM
 *  @desc: 实时天气信息
 *  @version:
 */
class RealtimeResponse(val status: String, val result: Result) {

    class Result(val realtime: Realtime)

    class Realtime(val skycon: String, val temperature: Float, @SerializedName("air_quality") val airQuality: AirQuality)

    class AirQuality(val aqi: AQI)

    class AQI(val chn: Float)

}