package com.example.roman.news.ui.adapter

import android.content.ClipData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_headlines.view.*

class TopHeadlineAdapter(
        private val itemClickListener: (News) -> Unit
) : RecyclerView.Adapter<TopHeadlinesHolder>(){

    private var listNews : List<News> = listOf()

    fun updateList(list : List<News>){
        listNews = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_top_headlines, parent, false)
        return TopHeadlinesHolder(view, itemClickListener)
    }
    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: TopHeadlinesHolder, position: Int) {
        holder.bind(listNews[position])
    }
}