package com.event.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.TimeUtils

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
    private val timeTv = itemView.findViewById<TextView>(R.id.time_tv)
    private val button = itemView.findViewById<Button>(R.id.button)

    fun bindTo(item: Event?) {
        contentTv.text = item?.content
        timeTv.text = item?.time?.let { TimeUtils.millis2Date(it).toString() }
        button.text = item?.id?.let { "event code : $it" }
        event = item
    }
}