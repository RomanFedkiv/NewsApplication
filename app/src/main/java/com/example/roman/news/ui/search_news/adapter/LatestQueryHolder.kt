package com.example.roman.news.ui.search_news.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.roman.news.data.model.ConfigSearchNews
import kotlinx.android.synthetic.main.item_search_result.view.*

class LatestQueryHolder (
    private val view: View,
    private val itemClickListener: (ConfigSearchNews) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bind(query : ConfigSearchNews): Unit = with(itemView) {
            search_text_view.setText(query.query)
            setOnClickListener { itemClickListener(query) }
        }
    }