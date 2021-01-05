package _test_;

import java.util.Objects;

public class Cha {
    String name;
    public static void display(){
        System.out.println("tu cha");
    }
    public static void printb(){
        System.out.println("tu cha");
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Cha)) return false;
//        Cha cha = (Cha) o;
//        return Objects.equals(name, cha.name);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
