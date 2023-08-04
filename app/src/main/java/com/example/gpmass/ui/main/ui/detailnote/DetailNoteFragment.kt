package com.example.gpmass.ui.main.ui.detailnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gpmass.databinding.FragmentDetailNoteBinding
import com.example.gpmass.room.entities.NoteEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNoteFragment : Fragment() {

    private lateinit var binding: FragmentDetailNoteBinding

    private lateinit var detailModel: NoteEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){
            detailModel = requireArguments().getSerializable("detailNote") as NoteEntity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = detailModel
    }
}