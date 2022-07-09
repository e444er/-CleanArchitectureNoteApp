package com.e444er.cleanarchitecturenoteapp.feature_note.presentation.util

sealed class Screen(val route: String){
    object NotesScreen: Screen("notes_screen")
    object AddEditNotesScreen: Screen("add_edit_notes_screen")
}
