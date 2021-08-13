package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import com.example.myposts.databinding.ActivityViewPostBinding
import com.example.postactivity.postRVAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewPostActivity : AppCompatActivity() {
    var postId =0
    lateinit var binding:ActivityViewPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityViewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postId = intent.getIntExtra("POST_ID", 0)

        getPost()
    }
    fun getPost() {
        var retrofit = Apiclient.buildService(ApiInterface::class.java)
        var request = retrofit.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                binding.tvName2.text = response.body()?.title
                binding.tvName3.text = response.body()?.body
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }}
