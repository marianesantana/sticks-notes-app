package com.example.notesapp.feature_note.data.repository

import com.example.notesapp.feature_note.data.data_source.NoteDao
import com.example.notesapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImplementation(
    val noteDao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return noteDao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note)
    }

}