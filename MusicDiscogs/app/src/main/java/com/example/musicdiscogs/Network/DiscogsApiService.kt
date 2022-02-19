package com.example.musicdiscogs.Network

import com.example.musicdiscogs.entities.ListOfAlbums
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.discogs.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//The implementation of the interface is done by Retrofit.
//Defines how Retrofit talks to the web server using HTTP requests.
interface DiscogsApiService {
    @GET("/database/search")
    fun getSearchResults(
        @Query("key") key: String,
        @Query("secret") secret: String,
        @Query("artist") search: String,
        @Query("country") country: String
    ) : Call<ListOfAlbums>
}

//call     Api.retrofitService()
object DiscogsApi {
    val retrofitService: DiscogsApiService by lazy { //Lazy means will not create until call to object.
        retrofit.create(DiscogsApiService::class.java)   //This is expensive. Thus the singleton.
        //This implements the Interface class. The body of each method.
    }
}