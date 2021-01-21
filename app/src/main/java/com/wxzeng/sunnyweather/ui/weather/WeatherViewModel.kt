package com.wxzeng.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wxzeng.sunnyweather.logic.Repository
import com.wxzeng.sunnyweather.logic.model.Location

/**
 *  @author: weixingzeng
 *  @e-mail: 330446962@qq.com
 *  @date 2021/01/20 3:54 PM
 *  @desc: 天气viewmodel
 *  @version:
 */
class WeatherViewModel :ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng =""

    var locationLat =""

    var placeName =""

    val weatherLiveData = Transformations.switchMap(locationLiveData){ location ->
        Repository.refreshWeather(location.lng,location.lat)
    }

    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value = Location(lng,lat)
    }
}