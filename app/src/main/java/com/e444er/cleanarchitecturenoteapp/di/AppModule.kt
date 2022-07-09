package com.e444er.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.e444er.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.e444er.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.e444er.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.e444er.cleanarchitecturenoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repo: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotesUseCase = GetNotesUseCase(repo),
            deleteNoteUseCase = DeleteNoteUseCase(repo),
            addNoteUseCase = AddNoteUseCase(repo),
            getNotesIdUseCase = GetNotesIdUseCase(repo),
        )
    }

}