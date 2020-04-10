package com.davidriad.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.davidriad.roomwordsample.data.Word
import com.davidriad.roomwordsample.room.WordDAO
import com.davidriad.roomwordsample.room.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val wordRepository: WordRepository

     val allWords: LiveData<List<Word>>

    init {
        val wordDAO = WordRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        wordRepository = WordRepository(wordDAO)
        allWords = wordRepository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
    wordRepository.insert(word)
    }
}