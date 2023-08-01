package com.example.gpmass.listener

import com.example.gpmass.room.entities.NoteEntity

interface ClickListener {
    fun onClickCard(note: NoteEntity)
}