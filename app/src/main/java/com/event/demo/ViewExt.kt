package com.event.demo

import android.view.View

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
var lastClickTime = 0L

fun View.clickNoRepeat(interval: Long = 500, action: (view: View) -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && currentTime >= lastClickTime && (currentTime - lastClickTime < interval)) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        action(it)
    }
}