package com.example.gpmass.ui.main.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gpmass.R
import com.example.gpmass.adapters.NotesAdapter
import com.example.gpmass.databinding.FragmentNotesBinding
import com.example.gpmass.di.manager.NavigationManager
import com.example.gpmass.ext.isNetworkAvailable
import com.example.gpmass.listener.ClickListener
import com.example.gpmass.room.entities.NoteEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesFragment : Fragment(), ClickListener {

    private var _binding: FragmentNotesBinding? = null

    private lateinit var homeViewModel: NotesViewModel

    private val binding get() = _binding!!

    private var adapter: NotesAdapter? = null

    @Inject
    lateinit var navigation: NavigationManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        _binding = FragmentNotesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadNotes()
    }

    private fun loadNotes(){

        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.textNotes.text = it
        }

        if(isNetworkAvailable(requireActivity())){
            homeViewModel.getAllNotes()
        }else{
            homeViewModel.getDataLocal()
        }

        homeViewModel.notesList.observe(viewLifecycleOwner) {
            if(!it.isNullOrEmpty()){
                binding.recyclerNotes.visibility = View.VISIBLE
                binding.ivEmptyList.visibility = View.GONE
                adapter = NotesAdapter(it, this)
                binding.recyclerNotes.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
                binding.recyclerNotes.setHasFixedSize(true)
                binding.recyclerNotes.adapter = adapter
            }else{
                binding.recyclerNotes.visibility = View.GONE
                binding.ivEmptyList.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickCard(note: NoteEntity) {
        Toast.makeText(requireContext(), note.title, Toast.LENGTH_SHORT).show()
        navigation.onNavigate(view, R.id.detailNoteFragment, buildArguments(note))
    }

    private fun buildArguments(movieEntity: NoteEntity): Bundle{
        val bundle = Bundle()
        bundle.putSerializable("detailNote", movieEntity)
        return bundle
    }
}