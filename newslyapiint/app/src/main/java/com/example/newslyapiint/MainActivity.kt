package com.example.newslyapiint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
//import com.littlemango.stacklayoutmanager.StackLayoutManager
import retrofit2.Response
import java.util.Stack


class MainActivity : AppCompatActivity() {
    lateinit var adapter: newsAdapter
    private var articles= mutableListOf<article>()
 lateinit var newsList:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      newsList = findViewById(R.id.newsList)
        adapter = newsAdapter(this@MainActivity, articles)
        newsList.adapter=adapter
        newsList.layoutManager=LinearLayoutManager(this@MainActivity)

        getnews()
    }

    private fun getnews() {
        val news = newserve.newsInstance.getheadlines("us", 1)
        news.enqueue(object : Callback<news> {
            override fun onFailure(call: Call<news>, t: Throwable) {
                Log.d("CHEEZYCODE", "error in fetching news", t)
            }

            override fun onResponse(call: Call<news>, response: Response<news>) {
                val news = response.body()
                if (news != null) {
                    Log.d("CHEEZYCODE", news.toString())
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()


                }

            }
        })
    }
}