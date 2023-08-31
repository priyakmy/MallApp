package com.appsinvo

import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=APi_Key
// https://newsapi.org/v2/everything?q=apple&from=2023-08-09&to=2023-08-09&sortBy=popularity&apiKey=APi_Key
const val Base_url="https://newsapi.org/"
const val APi_Key="a07e8bc2c89e4bba9bc8cf4edd17da79"

interface NewsInterface{
    @GET( "v2/top-headlines?apiKey=$APi_Key")

    fun getHeadlines(@Query(value =  "country") country: String, @Query(value= "page")  page: Int): Call<News>


    //"https://newsapi.org/v2/top-headlines?apiKey=a07e8bc2c89e4bba9bc8cf4edd17da79&country=in&page=1

}
object NewsService{
    val newInstance:NewsInterface
    init {
        val retrofit =Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newInstance= retrofit.create(NewsInterface::class.java)
    }
}