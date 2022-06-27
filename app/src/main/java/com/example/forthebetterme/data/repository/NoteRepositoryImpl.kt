package com.example.forthebetterme.data

import androidx.lifecycle.LiveData
import com.example.forthebetterme.data.repository.NoteRepository
import com.example.forthebetterme.model.Note
import com.example.forthebetterme.data.NoteDao

class NoteRepositoryImpl(val noteDao: NoteDao): NoteRepository {
    override fun save(note: Note) {
        noteDao.save(note)
    }

    override fun delete(note: Note) {
        noteDao.delete(note)
    }

    override fun getNoteById(id: Long): Note? = noteDao.getNoteById(id)

    override fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

}