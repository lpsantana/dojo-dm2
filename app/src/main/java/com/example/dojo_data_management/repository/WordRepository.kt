package com.example.dojo_data_management.repository

import androidx.annotation.WorkerThread
import com.example.dojo_data_management.data.Word
import com.example.dojo_data_management.data.WordDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}