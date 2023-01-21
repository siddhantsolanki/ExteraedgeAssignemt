package com.example.exteraedgeassigment.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exteraedgeassigment.R
import com.example.exteraedgeassigment.data.local.RocketDatabaseData

class RocketListAdapter(
    private val context: Context?,
    private val data: List<RocketDatabaseData>?,
    private val clickHandler: OnItemClicked?
) :
    RecyclerView.Adapter<RocketListAdapter.ViewHolder>() {
    var adapterData = data

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var rocketName = item.findViewById<TextView>(R.id.name_value)
        var rocketCountry = item.findViewById<TextView>(R.id.country_value)
        var rocketEngineNumber = item.findViewById<TextView>(R.id.engine_count_value)
        var rocketImage = item.findViewById<ImageView>(R.id.item_image_holder)
        var container = item.findViewById<CardView>(R.id.item_rocket_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_rocket_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = adapterData?.get(position)
        holder.apply {
            rocketName.text = item?.name
            rocketCountry.text = item?.country
            rocketEngineNumber.text = item?.enginesCount.toString()
            if (context != null) {
                Glide.with(context).load(item?.image?.get(0))
                    .error(R.drawable.ic_launcher_background).into(rocketImage)
            }
            container.setOnClickListener { item?.id?.let { it1 -> clickHandler?.onClick(it1) } }
        }
    }

    override fun getItemCount(): Int = adapterData?.size ?: 0
}

interface OnItemClicked {
    fun onClick(id: String)
}