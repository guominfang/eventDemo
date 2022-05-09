package com.event.demo.banner

import androidx.lifecycle.ViewModel
import com.event.demo.R

/**
 * @author gmf
 * @description
 * @date 2022/5/9.
 */
class BannerViewModel : ViewModel() {

    fun getBannerData(): List<Banner> {
        val bannerLists: ArrayList<Banner> = ArrayList()
        bannerLists.add(Banner(R.drawable.img_1))
        bannerLists.add(Banner(R.drawable.img))
        bannerLists.add(Banner(R.drawable.img_2))
        return bannerLists
    }
}