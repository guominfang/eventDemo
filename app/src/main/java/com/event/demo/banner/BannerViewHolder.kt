package com.event.demo.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.event.demo.R

/**
 * @author gmf
 * @description
 * @date 2022/5/9.
 */
class BannerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
) {
    private val bannerIv = itemView.findViewById<ImageView>(R.id.banner_iv)

    fun bindTo(item: Banner?) {
        item?.iconId?.let { bannerIv.setImageResource(it) }
    }
}