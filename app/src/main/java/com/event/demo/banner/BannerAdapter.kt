package com.event.demo.banner

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author gmf
 * @description
 * @date 2022/5/9.
 */
class BannerAdapter(var banners: List<Banner>) : RecyclerView.Adapter<BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bindTo(banners.get(position))
    }

    override fun getItemCount(): Int {
        return banners.size
    }

}