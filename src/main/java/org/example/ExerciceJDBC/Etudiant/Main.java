package org.example.ExerciceJDBC.Etudiant;

import org.example.ExerciceJDBC.Book.Book;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=etudiant"; //
        //demojdbc est le nom de la base// ceci est est l'adresse à laquelle on se connecte à la BDD
        String username = "postgres";
        String password = "fatima";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion échoué");
            }

            Statement statement = connection.createStatement();
            String request = "SELECT * FROM etudiant";
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nom"));
            }

            List<Etudiant> etudiants = new ArrayList<Etudiant>();
            while (resultSet.next()) {
                etudiants.add(Etudiant.builder()
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prenom"))
                        .numero_classe(resultSet.getString("numero_classe"))
                        .build());
            }
            System.out.println(etudiants);

            Scanner scanner = new Scanner(System.in);
            System.out.println("saisir ton nom");
            String nomSaisie = scanner.nextLine();
            System.out.println("saisir prenom");
            String prenomSaisie = scanner.nextLine();
            System.out.println("saisir numéro classe");
            String numero_classeSaisie = scanner.nextLine();
            System.out.println("saisir l'annee d'obtention sous format JJ/MM/AAAA");
            String dateSaisie = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateformater = LocalDate.parse(dateSaisie,formatter) ;



//            Date date_diplome;


            Etudiant etudiant = Etudiant.builder()
                    .nom(nomSaisie)
                    .prenom(prenomSaisie)
                    .numero_classe(numero_classeSaisie)
                    .date_diplome(dateformater)
                    .build();


            String request1 = "INSERT INTO etudiant (nom, prenom, numero_classe, date_diplome) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request1);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getNumero_classe());
            preparedStatement.setDate(4, Date.valueOf(etudiant.getDate_diplome()));

            System.out.println(etudiant);

            int nbrRows = preparedStatement.executeUpdate();
            System.out.println(nbrRows);

            System.out.println("Entrez le numero de classe dont vous souhaitez voir la liste des élèves");
            String numClasseSaisie = scanner.nextLine();

            String request_2 = "SELECT nom, prenom FROM etudiant WHERE numero_classe = '" + numClasseSaisie + "'";
            resultSet = statement.executeQuery(request_2);
            System.out.println(resultSet);

            while (resultSet.next()) { // tant qu'il y a des lignes qui vérifie la requete, il va les afficher
                System.out.println(resultSet.getString("nom") + " / " + resultSet.getString("prenom"));
            }
            System.out.println("Entrez le nom de l'étudiant que vous souhaitez supprimer");
            String supEtudiant = scanner.nextLine();

            String request_3 = "DELETE FROM etudiant WHERE nom = '" + supEtudiant + "'";
            int nbrLigneSup = statement.executeUpdate(request_3);

            if (nbrLigneSup >= 1) {
                System.out.println(" Vous avez supprimé " + nbrLigneSup + " Etudiant(s)");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
