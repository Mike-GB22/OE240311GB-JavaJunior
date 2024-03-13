//mip24 2024.03.13
package Sem2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DZ {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
        List<Animal> animals = new ArrayList<>();
        
        animals.add(new Cat("Барсик",1));
        animals.add(new Cat("Дымок",2, false));
        animals.add(new Cat("Тыгыдык",3));
        animals.add(new Cat("Пушок",4, false));
        animals.add(new Cat("Мармеладка",5));
        animals.add(new Cat("Бублик",6, false));
        animals.add(new Cat("Дурик",7));
        animals.add(new Dog("Шарик",1));
        animals.add(new Dog("Балбесик",2, false));
        animals.add(new Dog("Уголек",3, false));
        animals.add(new Dog("Кусака",5));
        animals.add(new Dog("Бабака",6, false));
        animals.add(new Dog("Дружок",8));
        animals.add(new Dog("Пирожок",10, false));

        for(Animal animal: animals){
            System.out.println(animal);
        }

        String separator = "---------------------------------------";

        int count = 1;
        for(Animal animal: animals){
            System.out.println(separator);
            System.out.println(separator);
            System.out.println(count++ + ". " +animal);
            System.out.println(separator);
            
            Class<?> clazz = animal.getClass();

            System.out.println(" - конструкторы: ");
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor constructor: constructors){
                System.out.println(constructor.getName() + ": " + constructor.toString());
            }

            System.out.println(separator);

            Field[] fields = clazz.getDeclaredFields();
            System.out.println(" - поля (собственые): ");
            for(Field field: fields){
                System.out.println(field.getName() + ": " + field.get(animal));
            }
            
            System.out.println();
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println(" - методы (собственые): ");
            for(Method method: methods){
                System.out.println(method.getName() + ": " + method.toString());
            }

            System.out.println(separator);            
            Field[] fieldsAll = clazz.getFields();
            System.out.println(" - поля (все): ");
            for(Field field: fieldsAll){
                System.out.println(field.getName() + ": " + field.get(animal));
            }
            System.out.println();
            Method[] methodsAll = clazz.getMethods();
            System.out.println(" - методы (все): ");
            for(Method method: methodsAll){
                System.out.println(method.getName() + ": " + method.toString());
            }

            System.out.println(separator);  
            System.out.println("Вызываем метод у животного makeSound:");
            Method makeSaund = clazz.getMethod("makeSound");
            makeSaund.invoke(animal);
            System.out.println();
        }

    }
}
