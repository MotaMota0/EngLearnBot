package com.ara.EnglishBot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name="wordTranslate")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String word;
    private String translate;
}
