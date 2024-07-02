package org.example.Demo03Heritage;

public class Main {
    public static void main(String[] args) {

        //Avant l'utilisation d'abstract dans nos classes
//        Animal an = new Animal(12);
//        System.out.println(an.toString());
//
//        Canide can1 = new Canide(13, "Hector1");
//        System.out.println(can1.getNom());
//
//        Animal can2_animal = new Canide(13, "Hector2");
//
//        an.crier(); //cri animal
//        can1.crier(); // cri canidé
//        can2_animal.crier(); // cri canidé
//
//        Canide can2_canide = (Canide) can2_animal;
//        System.out.println(can2_canide.getNom());
//
//
//        System.out.println(an);
//        System.out.println(can1);
//        System.out.println(can2_animal);
//        System.out.println(can2_canide);
//
//        System.out.println(Animal.getNbAnimaux());

        // Après l'ajout d'abstract
        // nous ne pouvons plus instancier que des chiens et hyennes
        Chien rex = new Chien(2, "Rex", "Chiuaua");
        Canide rex_canide = rex;
        Animal rex_animal = rex;
        Object rex_object = rex;

        rex.toString();
        rex_canide.toString();
        rex_animal.toString();
        rex_object.toString();

        rex.crier();
        rex_canide.crier();
        rex_animal.crier();
//        rex_object.crier();

        rex.getNom();
        rex_canide.getNom();
//        rex_animal.getNom();
//        rex_object.getNom();

        rex.aboyer();
//        rex_canide.aboyer();
//        rex_animal.aboyer();
//        rex_object.aboyer();

        System.out.println("--------------------------------");

        Animal[] animalerie = {
                rex,
                new Chien(13, "Pepette", "Rottweiller"),
                new Hyenne(15, "Renée")
        };

        for(Animal animal : animalerie){
            animal.crier();

            if(animal instanceof Chien){
                System.out.println("C'est un chien !!");
//                animal.aboyer();
                Chien chien = (Chien) animal;
                chien.aboyer();
            }


            if(animal instanceof Chien chien_siChien){
                // le bloc n'est exécuté que si nous avons une instance de la classe Chien dans la variable animal
                // de plus, si c'est le cas, chien_siChien prendra le conenu d'animal (le chien)
                chien_siChien.aboyer();
            }


            boolean variable = animal instanceof Chien chien_siChien;
        }

    }
}
