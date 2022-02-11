package com.example.networkconnection

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.networkconnection.entities.Repository
import com.example.networkconnection.entities.User
import com.example.networkconnection.network.GithubApi
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), retrofit2.Callback<User>  {
    lateinit var userTextView: TextView
    lateinit var avatarImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userTextView = findViewById(R.id.main_login)
        avatarImage = findViewById(R.id.main_avatar)


        val callUser = GithubApi.retrofitService.getUser("MadReza")
        val callFollowers = GithubApi.retrofitService.getFollowers("MadReza")
        val callRepositories = GithubApi.retrofitService.getRepositories("MadReza")

        callUser.enqueue(this)
        callFollowers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val listOfFollowers = response.body()
                if (listOfFollowers != null) {
                    for(follower in listOfFollowers) {
                        Log.e("MainActivity_CallFollow", follower.login)
                    }
                }

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        callRepositories.enqueue(object : Callback<List<Repository>> {
            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                val repositories = response.body()
                if (repositories != null)
                    for (repository in repositories){
                        repository?.name?.let { Log.e("Repository", it) }
                    }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        val user = response.body()
        if (user != null) {
            userTextView.text = user.login
            Picasso.get()
                .load(user.avatarUrl)
                .into(avatarImage)
        }
        else
            Log.e("MainActivity_onFailure", "Incorrect User")
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        Log.e("MainActivity_onFailure", "ERROR in retrieval of User")
    }
}