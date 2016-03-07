package com.github.ksoichiro.note.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    private Date createdAt;
}
