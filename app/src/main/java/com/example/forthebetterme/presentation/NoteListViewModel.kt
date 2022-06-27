package com.example.forthebetterme.presentation

import androidx.lifecycle.ViewModel
import com.example.forthebetterme.data.repository.NoteRepository
import com.example.forthebetterme.model.Note

class NoteListViewModel(val noteRepository: NoteRepository): ViewModel() {

    val notes=noteRepository.getAllNotes()

    fun delete(note: Note){
        noteRepository.delete(note)
    }

}