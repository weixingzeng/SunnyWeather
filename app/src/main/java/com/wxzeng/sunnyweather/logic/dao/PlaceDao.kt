package com.wxzeng.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.wxzeng.sunnyweather.SunnyWeatherApplication
import com.wxzeng.sunnyweather.logic.model.Place

/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/01/20 5:24 PM
 *  @desc: 数据层dao类
 *  @version:
 */
object PlaceDao {
    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place",Gson().toJson(place))
        }
    }

    fun getSvaePlace():Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}
