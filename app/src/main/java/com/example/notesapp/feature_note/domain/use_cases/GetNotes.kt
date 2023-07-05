package com.example.notesapp.feature_note.domain.use_cases

import com.example.notesapp.feature_note.data.repository.NoteRepository
import com.example.notesapp.feature_note.domain.model.Note
import com.example.notesapp.feature_note.domain.util.NoteOrder
import com.example.notesapp.feature_note.domain.util.NoteOrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Title(NoteOrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map {
            notes ->
            when(noteOrder.orderType){
                is NoteOrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> {
                            notes.sortedBy { it.title }
                        }
                        is NoteOrder.Date -> {
                            notes.sortedBy { it.timestamp }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedBy { it.color }
                        }
                    }
                }
                is NoteOrderType.Descending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> {
                            notes.sortedByDescending { it.title }
                        }
                        is NoteOrder.Date -> {
                            notes.sortedByDescending { it.timestamp }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedByDescending { it.color }
                        }
                    }
                }
            }
        }

    }
}