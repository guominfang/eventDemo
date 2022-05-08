package com.event.demo

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventAdapter : PagingDataAdapter<Event, EventViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(parent)
    }

    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem == newItem
            }
        }
    }
}