package com.example.forthebetterme.ui.note_list

import com.example.forthebetterme.model.Note

interface OnNoteEventListener {
    fun onNoteSelected(id: Long?)
    fun onNoteLongPress(note: Note?): Boolean
}