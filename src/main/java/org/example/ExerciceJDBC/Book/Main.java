package org.example.ExerciceJDBC.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=Exercice2"; //
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
            String request = "SELECT * FROM livre";
            ResultSet resultSet = statement.executeQuery(request);

            //.next() permet de parcourir les données présente dans notre
            //resultSet tant qu'il a une donné suivant il renvoie true sinon il renvoie false
            while (resultSet.next()) {
                System.out.println(resultSet.getString("titre") + " / " + resultSet.getString("auteur") + " / " + resultSet.getInt("id"));
            }

            statement.close();
            resultSet.close();

            String request2 = "SELECT * FROM livre WHERE id = 22 ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(request2);

            if (resultSet.next()) {
                System.out.println(resultSet.getString("titre") + "/" + resultSet.getString("auteur"));
            }

            statement.close();
            resultSet.close();


            statement = connection.createStatement();
            String request3 = "SELECT titre, id FROM livre";


            resultSet = statement.executeQuery(request);
            List<Book> books = new ArrayList<Book>();
            while (resultSet.next()) { //books.add(new Book()) ;
                books.add(Book.builder()
                        .id(resultSet.getInt("id"))
                        .title(resultSet.getString("titre"))
                        .author(resultSet.getString("auteur"))
                        .build()) ;
            }

            System.out.println(books);

            // j'instancie un nouveau livre en utilisant le builder crée juste avant

            Book book = Book.builder()
                    .title("Livre crée par Fatima")
                    .author("Fatima l'Unique")
                    .publisher("Salut")
                    .isbn10("1234567890")
                    .isbn13("XXXXXXXXXXXXX")
                    .publicationDate(LocalDate.now())
                    .build();

            String request4 = "INSERT INTO livre (titre,auteur, editeur, isbn_10, isbn_13, date_publication) VALUES (?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(request4);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setString(4, book.getIsbn10());
            preparedStatement.setString(5, book.getIsbn13());
            preparedStatement.setDate(6, Date.valueOf(book.getPublicationDate()));


            int nbrRows = preparedStatement.executeUpdate();
            System.out.println(nbrRows);

            if (nbrRows == 1) {
                System.out.println("livre ajouté");
            }
            else {
                System.out.println("erreur dans l'ajout");
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}

