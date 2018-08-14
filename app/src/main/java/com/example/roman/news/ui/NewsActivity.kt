package com.example.roman.news.ui

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.design.widget.NavigationView
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.news.NewsContract
import com.example.roman.news.ui.adapter.TopHeadlineAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.content_drawer.*
import javax.inject.Inject
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import com.example.roman.news.data.model.NewsConfig
import com.example.roman.news.ui.adapter.CountryConfig
import com.example.roman.news.ui.adapter.SearchAdapter
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.app_bar_drawer.*

import java.util.concurrent.TimeUnit


class NewsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, NewsContract.MainView {

    @Inject
    override lateinit var presenter : NewsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        setSupportActionBar(toolbar)
        AndroidInjection.inject(this)
        initView()
        presenter.start()

    }

    override fun successConfigure() {
        val intent = Intent(this, DetailNewsActivity::class.java)
        startActivity(intent)
    }

    override fun showNews(listNews: List<News>) {
        ( news_list.adapter as TopHeadlineAdapter).updateList(listNews)
    }

    fun initView() {
        fab.setOnClickListener {
            news_list.smoothScrollToPosition(0)
        }
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        initRecyclerView()
        search_button.setOnClickListener {
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView(){
        news_list.layoutManager = LinearLayoutManager(this)
        news_list.adapter = TopHeadlineAdapter{
            val newsConfig = NewsConfig(it.source,it.description,it.title,it.url,it.urlToImage,it.publishedAt)
            presenter.createNewsConfig(newsConfig)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ukr_item -> {
                searchTopHeadlinesForCountry(CountryConfig.UKRAINE)
            }
            R.id.rus_item -> {
                searchTopHeadlinesForCountry(CountryConfig.RUSSIA)
            }
            R.id.eng_item -> {
                searchTopHeadlinesForCountry(CountryConfig.UNITED_KINGDOM)
            }
            R.id.usa_item -> {
                searchTopHeadlinesForCountry(CountryConfig.USA)
            }
            R.id.ger_item -> {
                searchTopHeadlinesForCountry(CountryConfig.GERMANY)
            }
            R.id.pol_item -> {
                searchTopHeadlinesForCountry(CountryConfig.POLAND)
            }
            R.id.tur_item -> {
                searchTopHeadlinesForCountry(CountryConfig.TURKEY)
            }
            R.id.jap_item -> {
                searchTopHeadlinesForCountry(CountryConfig.JAPAN)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun searchTopHeadlinesForCountry(country : String) {
        presenter.updateTopHeadlines(country)
    }

    override fun showError() {
        presenter.stop()
    }
}
