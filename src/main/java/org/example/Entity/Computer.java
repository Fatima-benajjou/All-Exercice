package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // c'est ma BDD qui gère l'incrémentation
    // de l'ID
    private int id;

    private String imac;

    private LocalDate creationDate;

}
