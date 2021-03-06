package com.example.foodmarket.ui.order.inprogress

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarket.R
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.item_in_progress.view.*

class InProgressAdapter(
    private val listData: List<Data>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<InProgressAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_in_progress, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : Data, itemAdapterCallback : ItemAdapterCallback) {
            itemView.apply {
                tvTitle.text = data.food.name
                tvPrice.formatPrice(data.food.price.toString())

                Glide.with(context)
                    .load(data.food.picturePath)
                    .into(ivPoster)

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: Data)
    }

}