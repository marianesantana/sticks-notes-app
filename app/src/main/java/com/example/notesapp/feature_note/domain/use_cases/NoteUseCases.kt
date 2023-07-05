package com.example.notesapp.feature_note.domain.use_cases


data class NoteUseCases(
    val deleteNotes: DeleteNotes,
    val getNotes: GetNotes,
    val addNotes: AddNote,
    val getNote: GetNote
)
