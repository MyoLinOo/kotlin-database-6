package com.myogardener.worldroomdatabase6.DB

import androidx.lifecycle.LiveData

class WordRepository (private val wordDao: WordDao){

    val allWord: LiveData<List<Word>> = wordDao.getAllWord()

    suspend fun wordInsert(word: Word){
        wordDao.saveWord(word)
    }
    suspend fun deleteAll(){
        wordDao.deleteAll()
    }
    suspend fun deleteItem(name:String){
        wordDao.deleteItem(name)
    }
    suspend fun updateItem(updatName:String,name: String){
        wordDao.updateItem(updatName,name)
    }


}