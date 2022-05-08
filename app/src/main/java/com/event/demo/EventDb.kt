package com.event.demo

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
@Database(entities = [Event::class], version = 1)
abstract class EventDb : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        private var instance: EventDb? = null

        @Synchronized
        fun get(context: Context): EventDb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventDb::class.java, "EventDatabase"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            fillInDbContent(context.applicationContext)
                        }
                    }).build()
            }

            return instance!!
        }

        private fun fillInDbContent(context: Context) {
            ioThread {
                get(context).eventDao().insert(
                    LOCAL_DATA.map { Event(id = 0, content = it) }
                )
            }
        }
    }
}

private val LOCAL_DATA = arrayListOf(
    "老六", "葫芦娃", "海贼王", "路飞", "山治", "火影", "鸣人", "小樱",
    "犬夜叉", "老六a", "葫芦娃a", "海贼王a", "路飞a", "山治a", "火影a", "鸣人a", "小樱a",
    "犬夜叉a"
)