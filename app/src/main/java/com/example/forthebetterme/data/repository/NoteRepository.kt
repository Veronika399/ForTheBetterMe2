package com.example.forthebetterme.data.repository


import androidx.lifecycle.LiveData
import com.example.forthebetterme.model.Note


interface NoteRepository {
    fun save(note: Note)
    fun delete(note: Note)
    fun getNoteById(id: Long): Note?
    fun getAllNotes(): LiveData<List<Note>>
}