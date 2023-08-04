package com.example.gpmass.data.domain

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.data.repository.DataRepository
import com.example.gpmass.room.entities.NoteEntity
import javax.inject.Inject

class SaveDataRemoteUseCase @Inject constructor(private val repository: DataRepository) {

    suspend fun saveData(noteEntity: NoteEntity): ResponseModel {
        return repository.saveNote(noteEntity)
    }
}