package com.wxzeng.sunnyweather.logic.model

/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/01/20 3:04 PM
 *  @desc:封装实时天气和未来天气
 *  @version:
 */
class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)