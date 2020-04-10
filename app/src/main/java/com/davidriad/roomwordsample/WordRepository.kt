package com.davidriad.roomwordsample

import androidx.lifecycle.LiveData
import com.davidriad.roomwordsample.data.Word
import com.davidriad.roomwordsample.room.WordDAO

class WordRepository(private val wordDao: WordDAO) {
    var allWords: LiveData<List<Word>> = wordDao.getAscendingOrderWords()

    suspend fun insert(word: Word) {
        wordDao.insertWord(word)
    }
    
}