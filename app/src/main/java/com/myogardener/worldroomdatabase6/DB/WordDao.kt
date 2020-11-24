package com.myogardener.worldroomdatabase6.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WordDao {

    @Query(value = "Select * from table_word ORDER BY word_ame ASC")
    fun getAllWord(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveWord(word: Word)

    @Query("Delete from table_word")
    suspend fun deleteAll()

    @Query("DELETE FROM table_word WHERE word_ame=:name")
    suspend fun deleteItem(name:String)

    @Query("UPDATE table_word SET word_ame=:updateName WHERE word_ame=:name")
    suspend fun updateItem(updateName: String,name: String)

}