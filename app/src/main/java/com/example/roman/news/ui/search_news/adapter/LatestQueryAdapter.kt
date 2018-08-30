package com.example.roman.news.ui.search_news.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.roman.news.R
import com.example.roman.news.data.model.ConfigSearchNews

class LatestQueryAdapter (
        private val itemClickListener: (ConfigSearchNews) -> Unit
) : RecyclerView.Adapter<LatestQueryHolder>(){

    private var listConfigSearch : MutableList<ConfigSearchNews> = mutableListOf()

    fun updateList(list : List<ConfigSearchNews>){
        listConfigSearch = list.toMutableList()
        notifyDataSetChanged()
    }

    fun clearList(){
        listConfigSearch.clear()
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestQueryHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search_result, parent, false)
        return LatestQueryHolder(view, itemClickListener)
    }
    override fun getItemCount(): Int = listConfigSearch.size



    override fun onBindViewHolder(holder: LatestQueryHolder, position: Int) {
        holder.bind(listConfigSearch[position])
    }

}