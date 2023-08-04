package com.example.gpmass.ui.main.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gpmass.data.domain.GetDataUseCase
import com.example.gpmass.data.domain.NotesUsesCase
import com.example.gpmass.data.domain.SaveDataLocalUseCase
import com.example.gpmass.room.entities.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val getDataUseCase: GetDataUseCase,
                                         private val notesUsesCase: NotesUsesCase,
                                         private val saveDataLocalUseCase: SaveDataLocalUseCase): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Notes Blog App"
    }
    val text: LiveData<String> = _text

    var notesList = MutableLiveData<List<NoteEntity>>()

    fun getDataLocal(){
        viewModelScope.launch {
            notesList.postValue(getDataUseCase.getData())
        }
    }

    fun getAllNotes(){
        viewModelScope.launch {
            val result = notesUsesCase()
            saveAllNotesLocal(result.listNotes)
            notesList.postValue(result.listNotes)
        }
    }

    private suspend fun saveAllNotesLocal(listNotes: List<NoteEntity>) {
        if(!listNotes.isNullOrEmpty()){
            listNotes.forEach{
                println("${it.title} ${it.id}")
                saveDataLocalUseCase.saveData(it)
            }
        }
    }

    inline fun <reified T: Any> Any.cast(): T{
        return this as T
    }

}