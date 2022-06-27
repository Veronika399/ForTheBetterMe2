package com.example.forthebetterme.presentation

import androidx.lifecycle.ViewModel
import com.example.forthebetterme.data.repository.NoteRepository
import com.example.forthebetterme.model.Note

class NoteDetailsViewModel(val noteRepository: NoteRepository): ViewModel() {

    fun getNoteById(id: Long?): Note? {
        var note:Note? = null
        id?.let { note = noteRepository.getNoteById(id) }
        return note
    }

}