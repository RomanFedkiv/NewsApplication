package com.example.roman.news.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.roman.news.data.model.ConfigNews
import kotlinx.android.synthetic.main.item_search_result.view.*

class LatestQueryHolder (
    private val view: View,
    private val itemClickListener: (ConfigNews) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bind(query : ConfigNews): Unit = with(itemView) {
            search_text_view.setText(query.query)
            setOnClickListener { itemClickListener(query) }
        }
    }