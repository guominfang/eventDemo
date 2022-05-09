package com.event.demo

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
@Entity
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val content: String,
    val state: Int,
    val time: Long
)
