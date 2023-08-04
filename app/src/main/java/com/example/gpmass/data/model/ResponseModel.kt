package com.example.gpmass.data.model

import com.example.gpmass.room.entities.NoteEntity

data class ResponseModel (
    val success : Boolean,
    val noteSaved : NoteEntity,
    val message : String,
    val listNotes : List<NoteEntity>
)