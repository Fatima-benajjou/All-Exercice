package org.example.ExerciceJDBC.Etudiant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data //get et set importé
@Builder//
@NoArgsConstructor // constructeur sans argument, à vide
@AllArgsConstructor
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String numero_classe;
    private LocalDate date_diplome;
    }
