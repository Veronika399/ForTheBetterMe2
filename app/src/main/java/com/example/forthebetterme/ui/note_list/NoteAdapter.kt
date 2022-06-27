package com.example.forthebetterme.ui.note_list

import android.location.GnssAntennaInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forthebetterme.R
import com.example.forthebetterme.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteViewHolder>() {
    private val notes= mutableListOf<Note>()
    var onNoteSelectedListener: OnNoteEventListener?=null

    fun setNotes(notes: List<Note>){
        this.notes.clear()
        this.notes.addAll(notes)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.mojdan_item_note,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note=notes[position]
        holder.bind(note)
        onNoteSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onNoteSelected(note.id) }
            holder.itemView.setOnLongClickListener { listener.onNoteLongPress(note) }

        }
    }

    override fun getItemCount(): Int= notes.count()
}