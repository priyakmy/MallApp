package com.appsinvo.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.appsinvo.News
import com.appsinvo.NewsService
import com.appsinvo.R
import com.appsinvo.databinding.ActivityMainBinding
import com.appsinvo.databinding.ActivityNewsBinding
import com.appsinvo.extension.bindImageFromUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        getNews()
    }
    private fun getNews(){
        val news= NewsService.newInstance.getHeadlines("in",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if(news!= null )
                    Log.d("mall", news.toString() )

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Mall" ,"Error in fetching mall" ,t)
            }
        })

    }
    private fun getData() {
        val data = intent.getStringExtra("Name")
        val icon = intent.getIntExtra("image",0)
        binding.tvNews.text = data
        binding.ivNews.background =ContextCompat.getDrawable(this,icon)
    }
}