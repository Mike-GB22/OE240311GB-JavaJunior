package Sem3;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int age;
    private transient double GPA;

    public Student(String name, int age, double GPA){
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Studen: ");
        result.append("\n Name: " + name);
        result.append("\n Age : " + age);
        result.append("\n GPA : " + GPA);
        return result.toString();
    }   

    
}
