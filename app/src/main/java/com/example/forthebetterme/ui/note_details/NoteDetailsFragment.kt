package com.example.forthebetterme.ui.note_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.forthebetterme.databinding.MojdanNoteDetailsBinding
import com.example.forthebetterme.model.Note
import com.example.forthebetterme.presentation.NoteDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoteDetailsFragment: Fragment() {
    private lateinit var binding: MojdanNoteDetailsBinding
    private val viewModel: NoteDetailsViewModel by viewModel()
    private val args: NoteDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MojdanNoteDetailsBinding.inflate(layoutInflater)
        binding.fabGoBack.setOnClickListener { goBackToList() }
        return binding.root
    }

    private fun goBackToList() {
        val action = NoteDetailsFragmentDirections.actionNoteDetailsFragment3ToNoteListFragment3()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val note = viewModel.getNoteById(args.noteId)
        display(note)
    }

    private fun display(note: Note?) {
        note?.let {
            binding.apply {
                binding.textviewNoteDate.text=note.datum
                binding.textviewNoteNaslov.text=note.naslov
                binding.textviewNoteSadrzaj.text=note.sadrzaj
                return
            }
        }


    }



    companion object {
        val Tag = "NoteDetails"
        val NoteIdKey = "noteId"

        fun create(id: Long): Fragment {
            val fragment = NoteDetailsFragment()
            return fragment
        }
    }
}