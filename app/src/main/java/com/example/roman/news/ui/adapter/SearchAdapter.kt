package com.example.roman.news.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchAdapter (
        private val itemClickListener: (News) -> Unit
) :RecyclerView.Adapter<SearchHolder>(){

    private var listNews : List<News> = listOf()

    fun updateList(list : List<News>){
        listNews = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search_result, parent, false)
        return SearchHolder(view, itemClickListener)
    }
    override fun getItemCount(): Int = listNews.size



    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.bind(listNews[position])
    }

}