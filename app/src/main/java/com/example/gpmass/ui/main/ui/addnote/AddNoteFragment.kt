package com.example.gpmass.ui.main.ui.addnote

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gpmass.R
import com.example.gpmass.databinding.FragmentAddNoteBinding
import com.example.gpmass.room.entities.NoteEntity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null

    private val binding get() = _binding!!

    private lateinit var addNoteViewModel: AddNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addNoteViewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]

        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNoteViewModel.text.observe(viewLifecycleOwner) {
            //binding.textGallery.text = it
        }

        initListener()
    }

    private fun initListener() {
        binding.apply {
            linearSave.setOnClickListener {
                if(addNoteViewModel.validateFields(binding, textInputLayoutTitle, textInputLayoutAuthor, textInputLayoutContent)){
                    saveData(textInputLayoutTitle.editText?.text.toString().trim(),textInputLayoutAuthor.editText?.text.toString().trim(), textInputLayoutContent.editText?.text.toString().trim())
                }
            }
        }
    }

    private fun saveData(title: String, authorName: String, description: String) {
        addNoteViewModel.saveData(NoteEntity(title, authorName, description, Date().toString()))
        Snackbar.make(binding.root, R.string.ok_message, Snackbar.LENGTH_SHORT).show()
        addNoteViewModel.cleanInputs(binding)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}