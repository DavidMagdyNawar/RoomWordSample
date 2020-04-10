package com.davidriad.roomwordsample.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.davidriad.roomwordsample.data.Word
@Dao
interface WordDAO {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAscendingOrderWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word:Word)

    @Query("DELETE FROM word_table")
    suspend fun deleterAllWords()

}