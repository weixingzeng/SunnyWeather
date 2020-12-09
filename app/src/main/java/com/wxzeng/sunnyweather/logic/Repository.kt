package com.wxzeng.sunnyweather.logic

import androidx.lifecycle.liveData
import com.wxzeng.sunnyweather.logic.model.Place
import com.wxzeng.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun SearchPlaces(query:String) = liveData(Dispatchers.IO) {
        val result = try {
            val  placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResponse .status =="ok"){
                val  places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}