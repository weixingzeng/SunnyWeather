package com.wxzeng.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wxzeng.sunnyweather.logic.Repository
import com.wxzeng.sunnyweather.logic.model.Place

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