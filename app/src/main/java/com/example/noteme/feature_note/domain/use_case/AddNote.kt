package com.example.noteme.feature_note.domain.use_case

import com.example.noteme.feature_note.domain.model.InvalidNoteException
import com.example.noteme.feature_note.domain.model.Note
import com.example.noteme.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("Title of note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content of note can't be empty.")
        }
        repository.insertNote(note)
    }
}