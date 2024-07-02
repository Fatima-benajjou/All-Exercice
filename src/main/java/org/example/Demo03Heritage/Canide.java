package org.example.Demo03Heritage;

public abstract class Canide extends Animal{
    protected String nom;

    public Canide(int age, String nom) {
        super(age);
        this.nom = nom;
    }

    @Override
    public void crier() {
//        super.crier();
        System.out.println("cri du canidé !");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return super.toString() + "=> c'est en réalité un canidé nommé " + nom;
    }
}
