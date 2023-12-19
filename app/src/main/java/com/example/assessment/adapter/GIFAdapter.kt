package com.example.assessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment.R
import com.example.assessment.utils.ItemClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.gif_list_adapter.view.*

class GIFAdapter(
    private var data: ArrayList<String>,
    itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<GIFAdapter.GIFViewHolder>() {

    var itemClickListener: ItemClickListener? = null

    init {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GIFViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.gif_list_adapter, parent, false)
        return GIFViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GIFViewHolder, position: Int) {
        Picasso.get().load(data[position]).into(holder.imageView)
        holder.itemView.setOnClickListener {
            this.itemClickListener?.itemClick(data[position])
        }
    }

    fun update(data: ArrayList<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    class GIFViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: AppCompatImageView = view.image_view
    }
}
