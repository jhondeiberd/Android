package com.example.networkconnection.network

import com.example.networkconnection.entities.Repository
import com.example.networkconnection.entities.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Only accessible within the file
private const val BASE_URL = "https://api.github.com/"
//private const val BASE_URL = "https://api.discogs.com/oauth/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//The implementation of the interface is done by Retrofit.
//Defines how Retrofit talks to the web server using HTTP requests.
interface GithubApiService {

//    @GET("/database/search")
//    fun getSearchResults(
//        @Query("key") key: String = "HqxUsNVvKyCcWxTEqQOq",
//        @Query("secret") secret: String,
//        @Query("artist") search: String,
//        @Query("country") country: String
//    ) : Call<List<>>

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String) : Call<List<Repository>>

    @GET("users/{user}/followers")
    fun getFollowers(@Path("user") user: String) : Call<List<User>>

    @GET("users/{user}") //{} gets replace by the variable name
    fun getUser(@Path("user") user: String) : Call<User>

}

//call     GithubApi.retrofitService()
object GithubApi {
    val retrofitService: GithubApiService by lazy { //Lazy means will not create until call to object.
        retrofit.create(GithubApiService::class.java)   //This is expensive. Thus the singleton.
        //This implements the Interface class. The body of each method.
    }
}