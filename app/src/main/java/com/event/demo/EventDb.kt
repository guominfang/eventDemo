package com.event.demo

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
@Database(entities = [Event::class], version = 1, exportSchema = false)
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
                    LOCAL_DATA.map {
                        Event(
                            id = 0,
                            content = it,
                            state = 1,
                            time = System.currentTimeMillis()
                        )
                    }
                )
            }
        }
    }
}

private val LOCAL_DATA = arrayListOf(
    "妲己",
    "赵云",
    "曹擦",
    "诸葛亮",
    "米莱狄",
    "廉颇",
    "孙山西",
    "老六",
    "葫芦娃",
    "海贼王",
    "路飞",
    "山治",
    "火影",
    "鸣人",
    "小樱",
    "犬夜叉",
    "老六a",
    "葫芦娃a",
    "海贼王a",
    "路飞a",
    "山治a",
    "火影a",
    "鸣人a",
    "小樱a",
    "犬夜叉a",
    "老六b",
    "葫芦娃b",
    "海贼王b",
    "路飞b",
    "山治b",
    "火影b",
    "鸣人b",
    "小樱b",
    "犬夜叉b",
    "妲己AAAA",
    "赵云AAAA",
    "曹擦AAAA",
    "诸葛亮AAAA",
    "米莱狄AAAA",
    "廉颇AAAA",
    "孙山西AAAA",
    "老六AAAA",
    "葫芦娃AAAA",
    "海贼王AAAA",
    "路飞AAAA",
    "山治AAAA",
    "火影AAAA",
    "鸣人AAAA",
    "小樱AAAA",
    "犬夜叉AAAA",
    "老六aAAAA",
    "葫芦娃aAAAA",
    "海贼王aAAAA",
    "路飞aAAAA",
    "山治aAAAA",
    "火影aAAAA",
    "鸣人aAAAA",
    "小樱aAAAA",
    "犬夜叉aAAAA",
    "老六bAAAA",
    "葫芦娃bAAAA",
    "海贼王bAAAA",
    "路飞bAAAA",
    "山治bAAAA",
    "火影bAAAA",
    "鸣人bAAAA",
    "小樱bAAAA",
    "犬夜叉bAAAA"
)