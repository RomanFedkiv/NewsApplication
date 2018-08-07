package com.example.roman.news.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.topHeadlines.TopHeadlinesContract
import com.example.roman.news.ui.adapter.TopHeadlineAdapter
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*
import kotlinx.android.synthetic.main.content_drawer.*
import javax.inject.Inject
import android.os.Looper
import android.support.design.R.id.visible
import android.util.Log
import android.view.View
import com.example.roman.news.ui.adapter.SearchAdapter
import com.jakewharton.rxbinding2.widget.RxTextView
import com.squareup.picasso.Target
import java.util.concurrent.TimeUnit


class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, TopHeadlinesContract.View {

    @Inject
    override lateinit var presenter : TopHeadlinesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        setSupportActionBar(toolbar)
        AndroidInjection.inject(this)
        initView()
        presenter.start()

    }

    override fun showNews(listNews: List<News>) {
        (news_list.adapter as TopHeadlineAdapter).updateList(listNews)
    }

    override fun showSearchNews(listNews: List<News>) {
        listNews.forEach {
            Log.i("tttttt", it.title + ",")
        }
        (search_list.adapter as SearchAdapter).updateList(listNews)
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
        news_list.layoutManager = LinearLayoutManager(this)
        news_list.adapter = TopHeadlineAdapter()
        search_list.layoutManager = LinearLayoutManager(this)
        search_list.adapter = SearchAdapter()
        search_button.setOnClickListener {
                news_text_view.visibility = View.INVISIBLE
                query_input.visibility = View.VISIBLE
                search_list.visibility = View.VISIBLE
                initSearch()
        }
    }
    private fun initSearch() {
        val queryObserver = RxTextView.textChanges(query_input)
                .skipInitialValue()
                .map { it.toString() }
                .debounce(300, TimeUnit.MILLISECONDS)
        presenter.initSearch(queryObserver)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showError() {
        presenter.stop()
    }
}
