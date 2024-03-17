package Sem3;

import java.io.File;

//20240318 mip24 Сериализация 
public class Main {
    public static void main(String[] args) {
        File file = new File("student.txt");
        Student student = new Student("Ivan Ivanov Ivanovich", 12, 5);
        System.out.println("We have: " + student);
        System.out.println("---------------------");
        System.out.println("Serialization to file: " + file);
        StudentSerialization.serialization(student, file);

        Student studentFromFile = StudentSerialization.deSerialization(file);
        System.out.println("Serialization from file: " + file);
        System.out.println("---------------------");
        System.out.println("We have: " + studentFromFile);
    }    
}
