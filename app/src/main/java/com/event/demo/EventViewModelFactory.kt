package com.event.demo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventViewModelFactory(
    private val app:Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            val  eventDao = EventDb.get(app).eventDao()
            return EventViewModel(eventDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}