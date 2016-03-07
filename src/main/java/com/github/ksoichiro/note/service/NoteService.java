package com.github.ksoichiro.note.service;

import com.github.ksoichiro.note.entity.Note;
import com.github.ksoichiro.note.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note find(Integer id) {
        return noteRepository.findOne(id);
    }

    @Transactional
    public Note create(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note must not be null");
        }
        log.debug("Creating note: {}", note);
        note.setCreatedAt(new Date());
        return noteRepository.save(note);
    }

    @Transactional
    public Note update(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note must not be null");
        }
        if (note.getId() == null) {
            throw new IllegalArgumentException("Note object is not managed");
        }
        log.debug("Updating note: {}", note);
        return noteRepository.save(note);
    }
}
