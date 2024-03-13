package Sem2;

public class Cat  extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name, int age, boolean iHateDogs) {
        super(name, age);
        this.iHateDogs = iHateDogs;
    }

    public boolean iHateDogs = true;

    @Override
    public void makeSound() {
        System.out.println("Miau-miau");
    }

    public boolean iHateDogs() {
        return iHateDogs;
    }

    public void iHateDogs(boolean iHateDogs) {
        this.iHateDogs = iHateDogs;
    }
 
    @Override
    public String toString(){
        return super.toString("Cat", "iHateDogs: " + (iHateDogs?"yes":"no"));
    } 
}