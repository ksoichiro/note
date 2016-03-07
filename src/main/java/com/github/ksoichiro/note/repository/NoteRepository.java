package com.github.ksoichiro.note.repository;

import com.github.ksoichiro.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
