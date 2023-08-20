package com.example.a360news.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a360news.DataClass.Article
import com.example.a360news.R



class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
private var list:ArrayList<Article> = ArrayList<Article>()
    @SuppressLint("NotifyDataSetChanged")
    fun setNewsList(newsList:List<Article>){
        this.list=newsList as ArrayList<Article>
        notifyDataSetChanged()
    }

    class NewsViewHolder(val view: View):RecyclerView.ViewHolder(view) {

        val mainHeading:TextView=view.findViewById(R.id.mainHeading)
        val Headline:TextView=view.findViewById(R.id.headline)
        val author:TextView=view.findViewById(R.id.author)
        val publishedAt:TextView=view.findViewById(R.id.publishedAt)
        val companyName:TextView=view.findViewById(R.id.news_company_name)
        val newsimg: ImageView =view.findViewById(R.id.news_image)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item_list, parent, false))
    }


    override fun getItemCount(): Int {
       return list.size
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.Headline.text = list[position].description
        holder.mainHeading.text = list[position].title
        holder.author.text = list[position].author
//        val ago:String=findAgo
        holder.publishedAt.text = list[position].publishedAt
        holder.companyName.text = list[position].source.name
        Glide.with(holder.view.context).load(list[position].urlToImage).into(holder.newsimg)


    }

//    @SuppressLint("SimpleDateFormat")
//    private fun findAgo(dat: String): String {
//        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//        val date: Date = sdf.parse(dat) as Date
//        val niceDateStr: CharSequence = DateUtils.getRelativeTimeSpanString(
//            date.time,
//            Calendar.getInstance().getTimeInMillis(),
//            DateUtils.MINUTE_IN_MILLIS
//        )
//        return niceDateStr as String
//
//
//    }
}