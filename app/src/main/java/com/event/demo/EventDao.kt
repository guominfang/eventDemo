package com.event.demo

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
@Dao
interface EventDao {

    @Query("SELECT * FROM Event WHERE state = 1")
    fun allEventByContent(): PagingSource<Int, Event>

    @Query("SELECT * FROM Event WHERE id = :id")
    fun findEventById(id: Int): Event?

    @Insert
    fun insert(events: List<Event>)

    @Insert
    fun insert(event: Event)

    @Update
    fun updateEvent(event: Event)
}