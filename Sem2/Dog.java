package Sem2;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, boolean iLoveCats) {
        super(name, age);
        this.iLoveCats = iLoveCats;
    }
    public boolean iLoveCats = true;

    @Override
    public void makeSound() {
        System.out.println("Gav-gav");
    }

    public boolean isiLoveCats() {
        return iLoveCats;
    }

    public void setiLoveCats(boolean iLoveCats) {
        this.iLoveCats = iLoveCats;
    }

    @Override
    public String toString(){
        return super.toString("Dog", "iLoveCats: " + (iLoveCats?"yes":"no"));
    }
}
