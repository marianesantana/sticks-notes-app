package com.example.notesapp.feature_note.domain.util

sealed class NoteOrder(val orderType: NoteOrderType) {
    class Title(orderType: NoteOrderType): NoteOrder(orderType)
    class Date(orderType: NoteOrderType): NoteOrder(orderType)
    class Color(orderType: NoteOrderType): NoteOrder(orderType)

    fun copy(orderType: NoteOrderType): NoteOrder {
        return when(this){
            is Title -> Title(orderType)
            is Color -> Color(orderType)
            is Date -> Date(orderType)

        }
    }

}
