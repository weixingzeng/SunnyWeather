package com.wxzeng.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.wxzeng.sunnyweather.R
import com.wxzeng.sunnyweather.logic.model.Place
import kotlinx.android.synthetic.main.place_item.view.*

/**
 * @author: weixingzeng
 * @e-mail: 330446962@qq.com
 * @date 2020/12/09
 * @desc: 城市数据适配器
 * @version:1.0
 */
class PlaceAdapter(private val fragment:Fragment,private val placeList:List<Place>)
    :RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val placeName : TextView = view.findViewById(R.id.placeName)
        val placeAddress : TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = placeList.size

}