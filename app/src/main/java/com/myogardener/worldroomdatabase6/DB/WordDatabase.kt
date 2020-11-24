package com.myogardener.worldroomdatabase6.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Word::class)],version = 1)
abstract class WordDatabase: RoomDatabase() {

    abstract fun wordDao (): WordDao

    companion object{
        private var INSTANCE:  WordDatabase? = null
        fun getDatabase(context : Context):WordDatabase{
            val temDatabase = INSTANCE
            if(temDatabase != null){
                return temDatabase
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    WordDatabase::class.java,
                    "WordDB"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }
}