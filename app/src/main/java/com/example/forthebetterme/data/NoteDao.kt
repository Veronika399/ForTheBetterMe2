package com.example.forthebetterme.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.forthebetterme.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM note WHERE id =:id")
    fun getNoteById(id:Long):Note?

    @Query("SELECT * FROM note ORDER BY Datum DESC")
    fun getAllNotes():LiveData<List<Note>>



}