package com.example.myposts

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postactivity.postRVAdapter
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var idrecyclerview :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }
    fun fetchPosts(){
        var retrofit = Apiclient.buildService(ApiInterface::class.java)
        var request = retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()!!
                    idrecyclerview = findViewById(R.id.idrecyclerview)
                    idrecyclerview.layoutManager=LinearLayoutManager(baseContext)
                    val adapter = postRVAdapter(baseContext,post)
                    idrecyclerview.adapter =adapter
                    Toast.makeText(baseContext, "${post?.size} post", Toast.LENGTH_LONG).show()
                    var Post = mutableListOf<Post>()
                    for(x in 1..post.size){
                        Post.add(Post(3,56, "Developer", "Missing Information, sorry try again."))
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

