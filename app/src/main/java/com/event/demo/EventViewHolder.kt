package com.event.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
) {

    var event: Event? = null
    private val contentTv = itemView.findViewById<TextView>(R.id.content_tv)

    fun bindTo(item: Event?) {
        contentTv.text = item?.content
        event = item
    }
}