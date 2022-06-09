package com.ovais.sadapaycasestudy.base

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    var listItems: ArrayList<T> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) = run {
            field = value
            notifyDataSetChanged()
        }

    abstract var itemClickListener: (T) -> Unit
    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listItems[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(item: T, position: Int)
}