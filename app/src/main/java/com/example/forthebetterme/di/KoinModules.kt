package com.example.forthebetterme.di

import android.app.Application
import com.example.forthebetterme.data.NoteDao
import com.example.forthebetterme.data.NoteRepositoryImpl
import com.example.forthebetterme.data.repository.NoteRepository
import com.example.forthebetterme.data.room.NoteDataBase
import com.example.forthebetterme.presentation.NoteDetailsViewModel
import com.example.forthebetterme.presentation.NoteListViewModel
import com.example.forthebetterme.presentation.NoteNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): NoteDataBase {
        return NoteDataBase.getDatabase(application)
    }
    fun provideTaskDao(database: NoteDataBase): NoteDao{
        return database.getNoteDao()
    }
    single<NoteDataBase> { provideDatabase(get()) }
    single<NoteDao> { provideTaskDao(get()) }
}
    val repositoryModule = module {
    single<NoteRepository> { NoteRepositoryImpl(get()) }
    }
    val viewmodelModule = module {
        viewModel { NoteListViewModel(get())  }
        viewModel { NoteDetailsViewModel(get())  }
        viewModel { NoteNewViewModel(get())  }
    }