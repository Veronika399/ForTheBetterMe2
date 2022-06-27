package com.example.forthebetterme.ui.note_new


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.forthebetterme.databinding.MojdanNewNoteFragmentBinding
import com.example.forthebetterme.presentation.NoteNewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class NewNoteFragment: Fragment() {

    private lateinit var binding: MojdanNewNoteFragmentBinding
    private val viewModel: NoteNewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= MojdanNewNoteFragmentBinding.inflate(layoutInflater)
        binding.buttonSave.setOnClickListener { saveNote() }
        binding.buttonExitToStart.setOnClickListener { exitTostart() }

        return binding.root
    }



    private fun exitTostart() {
        val action=NewNoteFragmentDirections.actionNewNoteFragment4ToInitial()
        findNavController().navigate(action)
    }

    private fun saveNote() {
        val naslov =binding.edittextUserTitle.text.toString()
        val sadrzaj=binding.edittexttextmultiline.text.toString()
        val currentDate = SimpleDateFormat("dd.MM.yyyy.", Locale.getDefault()).format(
            Date()
        )
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(
            Date()
        )
        val datum: String = currentDate + " " + currentTime
        if(naslov.isEmpty() || sadrzaj.isEmpty()){
            Toast.makeText(activity, "Niste unijeli naslov i/ili sadržaj", Toast.LENGTH_SHORT).show()
        }

        if(naslov.isNotEmpty() && sadrzaj.isNotEmpty()) {
            viewModel.save(naslov, sadrzaj, datum)

            val action = NewNoteFragmentDirections.actionNewNoteFragment4ToNoteListFragment3()
            findNavController().navigate(action)
        }

    }

    companion object{
        val Tag="Novizapis"
        fun create():Fragment{
            return NewNoteFragment()
        }
    }
}