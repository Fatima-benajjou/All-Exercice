package org.example.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Computer computer = new Computer();
        computer.setImac("121212");
        computer.setCreationDate(LocalDate.now());

        em.persist(computer);
        em.getTransaction().commit();

//        em.close();
//        emf.close();

//        a la fin de l'utilisation de la classe computer

        Query query = em.createQuery("select c from Computer c", Computer.class) ;
        List<Computer> computerList = query.getResultList();

        System.out.println(computerList);

        try {
            Computer computer2 = em.getReference(Computer.class, 1);
            System.out.println(computer2);
        }catch (EntityNotFoundException e) {

            System.out.println(e.getMessage());

        }

        System.out.println(computer);

    }
}
