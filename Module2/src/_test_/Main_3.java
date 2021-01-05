package _test_;

import java.util.HashMap;
import java.util.Objects;

public class Main_3 {
    private final int value;

    public Main_3(int value) {
        this.value = value;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Main_3)) return false;
//        Main_3 main_3 = (Main_3) o;
//        return value == main_3.value;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }

//    @Override
//    public String toString() {
//        return "Main_3{" +
//                "value=" + value +
//                '}';
//    }

    public static void main(String[] args) {
        HashMap<Main_3, Integer> map = new HashMap<>();
        Main_3 key1 = new Main_3(1);
        Main_3 key2 = new Main_3(1);
        Main_3 key3 = new Main_3(2);
        map.put(key1, 1); // put in value for entry '1'
        map.put(key2, 2); // attempt to override value for entry '1'
        System.out.println(map.get(key1));
        System.out.println(map.get(key2));
        System.out.println(map.get(key3));
        System.out.println(map.size());
//        System.out.println(map.get(key4));
        System.out.println(key1);
        System.out.println(key2);
        System.out.println(key3);
        System.out.println(map.get(key1) == map.get(key2));
        System.out.println(key1.equals(key2));
        System.out.println(key1 == key2);
    }
}
