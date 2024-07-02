package org.example.Demo03Heritage;

public class Chien extends Canide{
    private String race;

    public Chien(int age, String nom, String race) {
        super(age, nom);
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public void crier() {
//        super.crier();
        System.out.println("Le chien abboie !");
    }

    public void aboyer(){
        this.crier();
    }

    @Override
    public String toString() {
        return "Chien{" +
                "race='" + race + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}
