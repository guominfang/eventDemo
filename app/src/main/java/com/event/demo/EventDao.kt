package com.event.demo

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
@Dao
interface EventDao {

    @Query("SELECT * FROM Event")
    fun allEventByContent(): PagingSource<Int, Event>

    @Insert
    fun insert(events: List<Event>)

    @Insert
    fun insert(event: Event)
}