package com.wxzeng.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName
/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: 服务器数据返回的Response 模型
 * @version:1.0
 */
data class PlaceResponse (val status: String,val places: List<Place>){

}
data class Place(val name:String,val location: Location,
                 @SerializedName("formatted_address") val address:String){

}

data class Location(val lng:String,val lat:String){}