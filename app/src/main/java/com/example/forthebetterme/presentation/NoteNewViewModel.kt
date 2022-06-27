package com.example.forthebetterme.presentation

import androidx.lifecycle.ViewModel
import com.example.forthebetterme.data.repository.NoteRepository
import com.example.forthebetterme.model.Note
import java.util.*

class NoteNewViewModel(val noteRepository: NoteRepository): ViewModel() {
    fun save(naslov: String, sadrzaj: String, datum: String){
        noteRepository.save(Note(0,naslov,sadrzaj,datum))
    }
}