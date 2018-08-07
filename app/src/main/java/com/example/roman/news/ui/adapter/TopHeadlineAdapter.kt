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

class TopHeadlineAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var listNews : List<News> = listOf()

    fun updateList(list : List<News>){
        listNews = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_top_headlines, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = listNews.size



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(listNews[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News): Unit = with(itemView) {
            title_textView.text = news.title
            publishedAt_textView.text = news.publishedAt

            Picasso.get()
                    .load(news.urlToImage)
                    .into(image_top_headlines)

        }
    }
}