package com.example.forthebetterme.ui.note_list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forthebetterme.databinding.MojdanNoteListFragmentBinding
import com.example.forthebetterme.model.Note
import com.example.forthebetterme.presentation.NoteListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoteListFragment: Fragment(), OnNoteEventListener {
    private lateinit var binding: MojdanNoteListFragmentBinding
    private lateinit var adapter: NoteAdapter
    private val viewModel: NoteListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=MojdanNoteListFragmentBinding.inflate(layoutInflater)
        binding.OutOfLists.setOnClickListener { exitfromlist() }
         setupRecyclerView()
        viewModel.notes.observe(viewLifecycleOwner){
            if(it !=null && it.isNotEmpty()){
                adapter.setNotes(it)
            }
        }

        return binding.root

    }

    private fun setupRecyclerView(){
        binding.noteListRvNotes.layoutManager=LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter= NoteAdapter()
        adapter.onNoteSelectedListener=this
        binding.noteListRvNotes.adapter=adapter
    }

        companion object{
            val Tag= "NoteList"

            fun create():Fragment{
                return NoteListFragment()
            }
        }


    private fun exitfromlist() {
        val action=NoteListFragmentDirections.actionNoteListFragment3ToInitial()
        findNavController().navigate(action)
    }

    override fun onNoteSelected(id: Long?) {
        val action =
            NoteListFragmentDirections.actionNoteListFragment3ToNoteDetailsFragment3(id ?: -1)
        findNavController().navigate(action)
    }

    override fun onNoteLongPress(note: Note?): Boolean {
        note?.let { it ->
            viewModel.delete(it)
        }
        return true
    }
}