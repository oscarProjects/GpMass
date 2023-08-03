package com.example.gpmass.ui.main.ui.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gpmass.R
import com.example.gpmass.data.domain.SaveDataUseCase
import com.example.gpmass.databinding.FragmentAddNoteBinding
import com.example.gpmass.room.entities.NoteEntity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val saveDataUseCase: SaveDataUseCase): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is AddNote Fragment"
    }
    val text: LiveData<String> = _text

    fun validateFields(binding: FragmentAddNoteBinding, vararg textFields: TextInputLayout):Boolean{
        var isValid = true

        for (tF in textFields   ){
            if(tF.editText?.text.toString().trim().isEmpty()){
                tF.error = binding.root.context.getString(R.string.helper_required)
                tF.editText?.requestFocus()
                isValid = false
            }else{
                tF.error = null
            }
        }

        if(!isValid) Snackbar.make(binding.root, R.string.error_message, Snackbar.LENGTH_SHORT).show()

        return isValid
    }

    fun saveData(noteEntity: NoteEntity){
        viewModelScope.launch {
            saveDataUseCase.saveData(noteEntity)
        }
    }

    fun cleanInputs(binding: FragmentAddNoteBinding){
        binding.apply {
            textInputLayoutTitle.editText?.setText("")
            textInputLayoutAuthor.editText?.setText("")
            textInputLayoutContent.editText?.setText("")
        }
    }
}