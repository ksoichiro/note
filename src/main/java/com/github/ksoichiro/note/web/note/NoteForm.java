package com.github.ksoichiro.note.web.note;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class NoteForm {
    @Size(max = 255)
    private String title;

    @NotEmpty
    private String content;
}
