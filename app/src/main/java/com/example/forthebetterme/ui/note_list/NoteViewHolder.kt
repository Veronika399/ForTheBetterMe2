package com.example.forthebetterme.ui.note_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forthebetterme.databinding.MojdanItemNoteBinding
import com.example.forthebetterme.model.Note

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(note: Note){
        val binding=MojdanItemNoteBinding.bind(itemView)
        binding.itemNoteTitle.text=note.naslov
        binding.TVTimeStamp.text=note.datum
    }
}