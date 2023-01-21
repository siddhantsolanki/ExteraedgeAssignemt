package com.example.exteraedgeassigment.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exteraedgeassigment.R

class RocketImagesAdapter(private val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<RocketImagesAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imageContainer: ImageView = item.findViewById(R.id.recycler_image_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_rocket_iamge, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = list[position]
        Glide.with(context).load(dataItem).into(holder.imageContainer)
    }

    override fun getItemCount(): Int = list.size
}