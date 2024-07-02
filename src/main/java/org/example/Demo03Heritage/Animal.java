package org.example.Demo03Heritage;

public abstract class Animal {
    protected int age;// accessible librement DANS LES CLASSES FILLES
    private static int nbAnimaux = 0; //uniquement dans cette classe

    public Animal(int age) {
        nbAnimaux ++;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNbAnimaux() {
        return nbAnimaux;
    }
    public abstract void crier();

    @Override
    public String toString() {
//        System.out.println(super.toString());
        return super.getClass().getSimpleName() + "{" +
                "Méthode tostring du parent/super => " + super.toString() +
                ", age=" + age +
                '}';
    }
}
