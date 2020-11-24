package com.myogardener.worldroomdatabase6.DB

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val wordRepository:WordRepository
    val allWord : LiveData<List<Word>>

    init {
        val wordDao = WordDatabase.getDatabase(application).wordDao()
        wordRepository = WordRepository(wordDao)
        allWord = wordRepository.allWord
    }
    fun insert(word: Word) = viewModelScope.launch {
        wordRepository.wordInsert(word)
    }
    fun deleteAll()= viewModelScope.launch {
        wordRepository.deleteAll()
    }
    fun deleteItem(name:String)= viewModelScope.launch {
        wordRepository.deleteItem(name)
    }
    fun updateItem(updateName:String,name: String)= viewModelScope.launch {
        wordRepository.updateItem(updateName,name)
    }

}