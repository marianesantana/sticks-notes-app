package com.example.notesapp.feature_note.domain.util

sealed class NoteOrderType {
    object Ascending: NoteOrderType()
    object Descending: NoteOrderType()

}
