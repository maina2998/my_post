package com.example.postactivity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.Post
import com.example.myposts.R
import com.example.myposts.ViewPostActivity

class postRVAdapter (var context:Context, var postlist: List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_item,parent,false)
        return PostViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPostList=postlist.get(position)
        holder.tvuserId.text=currentPostList.userId.toString()
        holder.tvid.text=currentPostList.id.toString()
        holder.tvtitle.text=currentPostList.title
        holder.tvbody.text=currentPostList.body
        holder.clPost.setOnClickListener{
           var intent = Intent(context, ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPostList.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
          context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}

class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvuserId=itemView.findViewById<TextView>(R.id.tvuserId)
    var tvid=itemView.findViewById<TextView>(R.id.tvid)
    var tvtitle=itemView.findViewById<TextView>(R.id.tvtitle)
    var tvbody=itemView.findViewById<TextView>(R.id.tvbody)
    var clPost = itemView.findViewById<ConstraintLayout>(R.id.cvDisplayposts)
}