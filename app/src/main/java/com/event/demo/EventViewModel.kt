package com.event.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventViewModel(private val dao: EventDao) : ViewModel() {
    
    val allEventList: Flow<PagingData<Event>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = true,
            maxSize = 100
        )
    ) {
        dao.allEventByContent()
    }.flow
        .map { pagingData ->
            pagingData.map { event -> event }
        }
        .cachedIn(viewModelScope)

    fun insert(text: CharSequence) = ioThread {
//        dao.insert(Event(id = 0, content = text.toString()))
    }

    fun update(id: Int) = ioThread {
        val event = dao.findEventById(id)
        event?.state = 1
        if (event != null) {
            dao.updateEvent(event)
        }
    }
}