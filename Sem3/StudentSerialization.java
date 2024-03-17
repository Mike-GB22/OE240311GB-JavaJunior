//20240318 mip24
package Sem3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class StudentSerialization {
    static public void serialization(Student student, File file){
        try(FileOutputStream fos = new FileOutputStream(file)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + file);
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IO error: " + file);
            e.printStackTrace();
        }
    }

    static public Student deSerialization(File file){
        try(FileInputStream fis = new FileInputStream(file)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Student) ois.readObject();
        } catch (IOException e){
            System.out.println("IO error: " + file);
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
