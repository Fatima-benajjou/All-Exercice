package org.example.ExerciceJDBC.Book;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //get et set importé
@Builder//
@NoArgsConstructor // constructeur sans argument, à vide
@AllArgsConstructor// constructeur avec tout les parametre
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private LocalDate publicationDate;
}



