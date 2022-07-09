package com.e444er.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.e444er.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.e444er.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class GetNotesIdUseCase(
    private val repo: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repo.getNoteById(id)
    }
}