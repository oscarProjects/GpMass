package com.example.gpmass.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gpmass.room.entities.NoteEntity.Companion.TABLE_NAME
import java.io.Serializable

@Entity(tableName = TABLE_NAME)
class
NoteEntity(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "authorName") val authorName: String,
    @ColumnInfo(name = "contentDesc") val contentDesc: String,
    @ColumnInfo(name = "dateCreate") val dateCreate: String
): Serializable {
    companion object{
        const val TABLE_NAME = "notes"
    }
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id = 0
}