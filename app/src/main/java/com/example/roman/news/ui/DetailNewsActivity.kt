package com.example.roman.news.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.news.NewsContract
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.news_detail.*
import javax.inject.Inject

class DetailNewsActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail_1)



    }


}