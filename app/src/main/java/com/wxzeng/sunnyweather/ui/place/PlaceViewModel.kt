package com.wxzeng.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wxzeng.sunnyweather.logic.Repository
import com.wxzeng.sunnyweather.logic.model.Place

/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: viewmodel层
 * @version:1.0
 */
class PlaceViewModel: ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Repository.SearchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}