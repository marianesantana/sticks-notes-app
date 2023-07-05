package com.example.notesapp.feature_note.domain.use_cases

import com.example.notesapp.feature_note.data.repository.NoteRepository
import com.example.notesapp.feature_note.domain.model.InvalidNoteException
import com.example.notesapp.feature_note.domain.model.Note
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the note cannot be empty")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note cannot be empty")

        }
        repository.insertNote(note)
    }
}