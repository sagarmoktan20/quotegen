package com.example.newslyapiint

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class newsAdapter(val context:Context,val articles:List<article>):Adapter<newsAdapter.ArticleViewholder>() {

    class ArticleViewholder(itemView: View):ViewHolder(itemView){
        var newsImage=itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription=itemView.findViewById<TextView>(R.id.newsDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewholder {
    val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewholder(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewholder, position: Int) {
       val article=articles[position]
        holder.newsTitle.text =article.title
        holder.newsDescription.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }
}