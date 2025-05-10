package com.example.notetakingapp.controller;

import com.example.notetakingapp.model.Note;
import com.example.notetakingapp.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NoteControllerTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteController noteController;

    public NoteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addNote_shouldReturnSavedNote() {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        when(noteRepository.save(any(Note.class))).thenReturn(note);

        ResponseEntity<Note> response = noteController.addNote(note);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test Title", response.getBody().getTitle());
    }

    @Test
    void getNoteById_shouldReturnNote() {
        Long noteId = 1L;
        Note note = new Note();
        note.setId(noteId);
        note.setTitle("Test Title");
        note.setContent("Test Content");

        when(noteRepository.findById(noteId)).thenReturn(Optional.of(note));

        ResponseEntity<Note> response = noteController.getNoteById(noteId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test Title", response.getBody().getTitle());
    }

    @Test
    void getNoteById_shouldReturnNotFound() {
        Long noteId = 1L;

        when(noteRepository.findById(noteId)).thenReturn(Optional.empty());

        ResponseEntity<Note> response = noteController.getNoteById(noteId);
        assertEquals(404, response.getStatusCodeValue());
    }
}