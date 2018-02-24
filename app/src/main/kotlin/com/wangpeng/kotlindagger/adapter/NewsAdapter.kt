package com.wangpeng.kotlindagger.adapter

import android.app.Service
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wangpeng.kotlindagger.R
import com.wangpeng.kotlindagger.databinding.ItemNewsBinding

/**
 * Created by wangpeng on 2018/2/23.
 */
class NewsAdapter(var titles: List<String>, var context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
        var title: String = titles.get(position);
        holder?.mItemNewsBinding?.title?.setText(title)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
        var mLayoutInflater: LayoutInflater = context.getSystemService(Service.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var mItemNewsBinding: ItemNewsBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_news, parent, false)
        return NewsViewHolder(mItemNewsBinding);
    }

    override fun getItemCount(): Int {
        return titles.size;
    }

    class NewsViewHolder(var mItemNewsBinding: ItemNewsBinding) : RecyclerView.ViewHolder(mItemNewsBinding.root) {
    }
}