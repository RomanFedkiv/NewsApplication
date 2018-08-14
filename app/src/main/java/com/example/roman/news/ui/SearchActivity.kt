package com.example.roman.news.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.Window
import com.example.roman.news.R
import com.example.roman.news.data.model.ConfigSearchNews
import com.example.roman.news.data.model.News
import com.example.roman.news.presentation.search_news.SearchNewsContract
import com.example.roman.news.ui.adapter.LatestQueryAdapter
import com.example.roman.news.ui.adapter.SearchAdapter
import com.jakewharton.rxbinding2.widget.RxTextView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchNewsContract.SearchView{

    @Inject override lateinit var presenter: SearchNewsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)
        AndroidInjection.inject(this)
        initView()

        presenter.start()
    }

    private fun initView(){
        cancel_button.setOnClickListener { finish() }
        query_edit.setOnClickListener {
            latest_constraint_layo.visibility = INVISIBLE
            result_list.visibility = VISIBLE
        }
        search_Button.setOnClickListener {
            if (query_edit!=null) actionWithClick(query_edit.text.toString())
        }
        clear_all.setOnClickListener {
            presenter.clearLatestQuery()
        }
        initRecyclerView()
        initSearch()
    }


    private fun initSearch() {
        val queryObserver = RxTextView.textChanges(query_edit)
                .skipInitialValue()
                .map { it.toString() }
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinct()

      if (query_edit!=null) presenter.initSearch(queryObserver)
    }

    private fun initRecyclerView(){
        result_list.layoutManager = LinearLayoutManager(this)
        result_list.adapter = SearchAdapter{
            actionWithClick(it.title)
        }
        latest_query_list.layoutManager = LinearLayoutManager(this)
        latest_query_list.adapter =  LatestQueryAdapter{
            actionWithClick(it.query)
        }
    }

    override fun clearLatestQuery() {
        (latest_query_list.adapter as LatestQueryAdapter).clearList()
    }

    override fun showResultSearch(listNews: List<News>) {
        (result_list.adapter as SearchAdapter).updateList(listNews)
    }

    override fun successConfigure() {
        val intent = Intent(this, NewsActivity::class.java)
        startActivity(intent)
    }

    override fun showLatestQuery(listLatestQuery: List<ConfigSearchNews>) {
        (latest_query_list.adapter as LatestQueryAdapter).updateList(listLatestQuery.reversed())
}

    private fun actionWithClick(query : String?){
        presenter.createConfig(query)
    }

    override fun showError() {
    }
}