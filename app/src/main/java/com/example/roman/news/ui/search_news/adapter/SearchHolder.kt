package com.example.roman.news.ui.search_news.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.roman.news.data.model.News
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchHolder (
        private val view: View,
        private val itemClickListener: (News) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(news: News): Unit = with(itemView) {
        search_text_view.setText(news.title)
        setOnClickListener { itemClickListener(news) }
    }
}