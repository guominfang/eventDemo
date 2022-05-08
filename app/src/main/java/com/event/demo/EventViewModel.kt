package com.event.demo

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventViewModel(private val dao: EventDao): ViewModel() {


    fun insert(text: CharSequence) = ioThread {
        dao.insert(Event(id = 0, content = text.toString()))
    }
}