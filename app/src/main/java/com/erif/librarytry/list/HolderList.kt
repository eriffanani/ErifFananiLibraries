package com.erif.librarytry.list

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erif.librarytry.R

class HolderList(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val parent: FrameLayout = itemView.findViewById(R.id.item_parent)
    private val textView: TextView = itemView.findViewById(R.id.item_textView)

    fun bind(item: String, position: Int, callback: CallbackList?) {
        textView.text = item
        parent.setOnClickListener {
            callback?.onItemClick(position)
        }
    }

}