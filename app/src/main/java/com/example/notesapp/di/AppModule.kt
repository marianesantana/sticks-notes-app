package com.example.notesapp.di

import android.app.Application
import android.provider.DocumentsContract.Root
import androidx.room.Room
import com.example.notesapp.feature_note.data.data_source.NoteDatabase
import com.example.notesapp.feature_note.data.repository.NoteRepository
import com.example.notesapp.feature_note.data.repository.NoteRepositoryImplementation
import com.example.notesapp.feature_note.domain.use_cases.AddNote
import com.example.notesapp.feature_note.domain.use_cases.DeleteNotes
import com.example.notesapp.feature_note.domain.use_cases.GetNote
import com.example.notesapp.feature_note.domain.use_cases.GetNotes
import com.example.notesapp.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

        @Provides
        @Singleton
        fun provideNoteRepository(db: NoteDatabase): NoteRepository {
            return NoteRepositoryImplementation(db.noteDao)
        }

        @Provides
        @Singleton
        fun provideNoteUseCase(repository: NoteRepository): NoteUseCases {
            return NoteUseCases(
                getNotes = GetNotes(repository),
                deleteNotes = DeleteNotes(repository),
                addNotes = AddNote(repository),
                getNote = GetNote(repository),

                )
        }
    }
}