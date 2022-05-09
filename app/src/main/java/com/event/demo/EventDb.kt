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
                            state = 0,
                            time = System.currentTimeMillis()
                        )
                    }
                )
            }
        }
    }
}

private val LOCAL_DATA = arrayListOf(
    "ImageView",
    "ImageView & widget",
    "ImageView & contentScrim",
    "ImageView & popupTheme",
    "ImageView & titleCentered",
    "CollapsingToolbarLayout",
    "CollapsingToolbarLayout & widget",
    "CollapsingToolbarLayout & contentScrim",
    "CollapsingToolbarLayout & popupTheme",
    "CollapsingToolbarLayout & titleCentered",
    "CollapsingToolbarLayout & titleMargin",
    "CollapsingToolbarLayout & titleMarginEnd",
    "CollapsingToolbarLayout & titleMarginStart",
    "CollapsingToolbarLayout & layout_width",
    "CollapsingToolbarLayout & layout_centerHorizontal",
    "Toolbar",
    "Toolbar & widget",
    "Toolbar & contentScrim",
    "Toolbar & popupTheme",
    "Toolbar & titleCentered",
    "AppBarLayout",
    "AppBarLayout & widget",
    "AppBarLayout & contentScrim",
    "AppBarLayout & popupTheme",
    "AppBarLayout & titleCentered",
    "ImageView & State",
    "ImageView & widget & State",
    "ImageView & contentScrim & State",
    "ImageView & popupTheme & State",
    "ImageView & titleCentered & State",
    "CollapsingToolbarLayout & State",
    "CollapsingToolbarLayout & widget & State",
    "CollapsingToolbarLayout & contentScrim & State",
    "CollapsingToolbarLayout & popupTheme & State",
    "CollapsingToolbarLayout & titleCentered & State",
    "CollapsingToolbarLayout & titleMargin & State",
    "CollapsingToolbarLayout & titleMarginEnd & State",
    "CollapsingToolbarLayout & titleMarginStart & State",
    "CollapsingToolbarLayout & layout_width & State",
    "CollapsingToolbarLayout & layout_centerHorizontal & State",
    "Toolbar & State",
    "Toolbar & widget & State",
    "Toolbar & contentScrim & State",
    "Toolbar & popupTheme & State",
    "Toolbar & titleCentered & State",
    "AppBarLayout & State",
    "AppBarLayout & widget & State",
    "AppBarLayout & contentScrim & State",
    "AppBarLayout & popupTheme & State",
    "AppBarLayout & titleCentered & State",
)