package Sem2;

abstract public class Animal {
    public String name;
    public int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract public void makeSound();

    public String toString(){
        return toString("Animal", "");
    }

    public String toString(String type, String ext){
        return String.format("%s, name: %s, age: %d, %s", type, name, age, ext);
    }

}
