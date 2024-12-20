package com.example.bili.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bili.databinding.AdapterViewpager2Binding
import com.example.bili.model.UpList

class ViewPager2Adapter (
    val upList: List<UpList>
):RecyclerView.Adapter<ViewPager2Adapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = AdapterViewpager2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = upList[position]
        holder.binding.textView.text = "${item.id}的动态"
        holder.binding.imageView.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int {
        return upList.size
    }

    class MyViewHolder(val binding: AdapterViewpager2Binding):RecyclerView.ViewHolder(binding.root)
}
