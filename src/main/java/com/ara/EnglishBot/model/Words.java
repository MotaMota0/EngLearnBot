package com.ara.EnglishBot.model;


import jakarta.persistence.*;
import lombok.Data;


@Table
@Data
@Entity(name="words")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String engl;
    private String kazakh;
}
