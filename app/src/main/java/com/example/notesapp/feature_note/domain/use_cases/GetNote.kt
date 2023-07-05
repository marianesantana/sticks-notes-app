package com.example.notesapp.feature_note.domain.use_cases

import com.example.notesapp.feature_note.data.repository.NoteRepository
import com.example.notesapp.feature_note.domain.model.Note

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}