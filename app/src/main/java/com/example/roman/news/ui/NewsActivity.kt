package com.example.roman.news.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.roman.news.R
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.news.NewsContract
import com.example.roman.news.ui.adapter.TopHeadlineAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.app_bar_drawer.*
import kotlinx.android.synthetic.main.content_drawer.*
import javax.inject.Inject
import android.view.View
import com.example.roman.news.ui.adapter.SearchAdapter
import com.jakewharton.rxbinding2.widget.RxTextView
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

    override fun showNews(listNews: List<News>) {
        (news_list.adapter as TopHeadlineAdapter).updateList(listNews)
    }

    override fun showSearchNews(listNews: List<News>) {
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

        news_list.adapter = TopHeadlineAdapter{
            presenter.goToDetailView(it)
        }

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
        when (item.itemId) {
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showError() {
        presenter.stop()
    }
}
