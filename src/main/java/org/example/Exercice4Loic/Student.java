package org.example.Exercice4Loic;

public class Student {
    private int id;
    private static int nbStudents = 0;
    private String name;
    private int age;

    public Student(String name, int age)  {
        this.id = ++nbStudents;
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\t- Student : " +
                "name='" + name + '\'' +
                ", age=" + age +
                '.';
    }
}
