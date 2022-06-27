package com.example.forthebetterme.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forthebetterme.data.NoteDao
import com.example.forthebetterme.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)

abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE: NoteDataBase? = null

        fun getDatabase(context: Context): NoteDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): NoteDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                NoteDataBase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}
