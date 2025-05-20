package com.example.notetakingapp.controller;

import com.example.notetakingapp.model.Note;
import com.example.notetakingapp.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        noteRepository.deleteAll();
    }

    @Test
    void addNote_shouldReturnSavedNote() throws Exception {
        String noteJson = "{\"title\":\"Test Title\", \"content\":\"Test Content\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/notes")
                        .contentType(MediaType.APPLICATION_JSON) // Используйте APPLICATION_JSON
                        .content(noteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Title"));
    }

    @Test
    void getAllNotes_shouldReturnNotes() throws Exception {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");
        noteRepository.save(note);

        mockMvc.perform(MockMvcRequestBuilders.get("/notes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Title"));
    }
}