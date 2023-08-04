package com.example.gpmass.data.domain

import com.example.gpmass.data.repository.DataBaseRepository
import com.example.gpmass.room.entities.NoteEntity
import javax.inject.Inject

class SaveDataLocalUseCase @Inject constructor(private val dataBaseRepository: DataBaseRepository) {

    suspend fun saveData(noteEntity: NoteEntity){
         dataBaseRepository.saveData(noteEntity)
    }
}