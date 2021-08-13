package com.example.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.Comments
import com.example.myposts.R
import org.w3c.dom.Comment

class RvCommentsAdapter(var commentList:List<Comments>):RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_view_post,parent,false)
        return CommentsViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.tvcommentid.text= currentComment.id.toString()
        holder.tvcommenttitle.text=currentComment.title
        holder.tvcommentbody.text=currentComment.body
        holder.tvcommentbody.text=currentComment.userid


    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvcommentuserid=itemView.findViewById<TextView>(R.id.tvuserid)
    var tvcommenttitle=itemView.findViewById<TextView>(R.id.tvtitle)
    var tvcommentbody=itemView.findViewById<TextView>(R.id.tvbody)
    var tvcommentid=itemView.findViewById<TextView>(R.id.tvid)

}