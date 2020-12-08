package bai7_abstract_class_interface.thuc_hanh.p1_animal.animal;
import bai7_abstract_class_interface.thuc_hanh.p1_animal.edible.Edible;
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
