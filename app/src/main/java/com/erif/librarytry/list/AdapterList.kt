package com.erif.librarytry.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erif.librarytry.R

class AdapterList: RecyclerView.Adapter<HolderList>() {

    private var list: MutableList<String> = ArrayList()
    private var callback: CallbackList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList {
        val inflater = LayoutInflater.from(parent.context)
        return HolderList(
            inflater.inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HolderList, position: Int) {
        val item = list[position]
        holder.bind(item, position, callback)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: MutableList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun onItemClick(callback: CallbackList) {
        this.callback = callback
    }

}