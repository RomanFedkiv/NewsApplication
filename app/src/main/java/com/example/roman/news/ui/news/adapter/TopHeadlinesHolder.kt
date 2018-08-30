package com.example.roman.news.ui.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.roman.news.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_headlines.view.*

class TopHeadlinesHolder (
        private val view: View,
        private val itemClickListener: (News) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(news: News): Unit = with(itemView) {
        title_textView.text = news.title
        publishedAt_textView.text = news.publishedAt
        Picasso.get()
                .load(news.urlToImage)
                .into(image_top_headlines)
        setOnClickListener { itemClickListener(news) }
    }
}