package com.example.gpmass.data.domain

import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.data.repository.DataRepository
import javax.inject.Inject

class NotesUsesCase @Inject constructor(
    private val repository: DataRepository
){
    suspend operator fun invoke() : ResponseModel = repository.getAllNotes()
}