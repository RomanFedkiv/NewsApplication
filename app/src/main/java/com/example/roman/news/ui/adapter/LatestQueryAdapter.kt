package com.example.roman.news.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.roman.news.R
import com.example.roman.news.data.model.ConfigNews

class LatestQueryAdapter (
        private val itemClickListener: (ConfigNews) -> Unit
) : RecyclerView.Adapter<LatestQueryHolder>(){

    private var listConfig : MutableList<ConfigNews> = mutableListOf()

    fun updateList(list : List<ConfigNews>){
        listConfig = list.toMutableList()
        notifyDataSetChanged()
    }

    fun clearList(){
        listConfig.clear()
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestQueryHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search_result, parent, false)
        return LatestQueryHolder(view, itemClickListener)
    }
    override fun getItemCount(): Int = listConfig.size



    override fun onBindViewHolder(holder: LatestQueryHolder, position: Int) {
        holder.bind(listConfig[position])
    }

}