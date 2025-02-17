package com.ara.EnglishBot.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="words")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String engl;
    private String kazakh;

    public String getEngl() {
        return engl;
    }

    public void setEngl(String engl) {
        this.engl = engl;
    }

    public String getKazakh() {
        return kazakh;
    }

    public void setKazakh(String kazakh) {
        this.kazakh = kazakh;
    }
}
