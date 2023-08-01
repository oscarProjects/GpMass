package com.example.gpmass.data.domain

import com.example.gpmass.data.repository.DataBaseRepository
import com.example.gpmass.room.entities.NoteEntity
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val dataBaseRepository: DataBaseRepository) {

    suspend fun getData(): List<NoteEntity>{
        return dataBaseRepository.getData()
    }
}