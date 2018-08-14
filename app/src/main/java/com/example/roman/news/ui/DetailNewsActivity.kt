package com.example.roman.news.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.roman.news.R
import com.example.roman.news.WebDetailView
import com.example.roman.news.data.model.News
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.presentation.news_detail.NewsDetailContract
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.news_detail_1.*
import javax.inject.Inject

class DetailNewsActivity : AppCompatActivity(), NewsDetailContract.DetailView {

    @Inject override lateinit var presenter: NewsDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail_1)
        AndroidInjection.inject(this)
        presenter.start()
    }

    private fun initWebViewButton(url : String?) {
        web_view_button.setOnClickListener {
            val intent = Intent(this, WebDetailView::class.java)
            intent.putExtra("key",url)
            startActivity(intent)
        }
    }

    private fun initSourceClick(url: String?) {
        source.setOnClickListener {
            val intent = Intent(this, WebDetailView::class.java)
            intent.putExtra("key",url)
            startActivity(intent)
        }
    }

    override fun showDetailNews(news : NewsConfig) {
        initWebViewButton(news.url)
        initSourceClick(news.source)
        title_textView_detail.setText(news.title)
        publishedAt.setText(news.publishedAt)
        description.setText(news.description)
        source.setText(news.source)
        Picasso.get().load(news.urlToImage).into(detail_image_view)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }





}