package com.example.gpmass.ui.main.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gpmass.data.domain.GetDataUseCase
import com.example.gpmass.data.domain.NotesUsesCase
import com.example.gpmass.data.domain.SaveDataUseCase
import com.example.gpmass.data.model.ResponseModel
import com.example.gpmass.room.entities.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val getDataUseCase: GetDataUseCase,
                                         private val notesUsesCase: NotesUsesCase): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    var notesList = MutableLiveData<List<NoteEntity>>()

    val notesModel = MutableLiveData<ResponseModel?>()

    fun getData(){
        viewModelScope.launch {
            notesList.postValue(getDataUseCase.getData())
        }
    }

    fun getAllNotes(){
        viewModelScope.launch {
            val result = notesUsesCase()
            if(result != null){
                notesModel.postValue(result)
            }
        }
    }

}