package _test_;

import java.util.HashMap;
import java.util.Map;

public class Main_1 {
    private static Map<Cha, String> map = new HashMap<>();
    public static void main(String[] args) {
        Cha cha1 = new Cha();
        Cha cha2 = new Cha();
        map.put(cha1, "a");
        map.put(cha2, "b");
        showMap();
    }

    public static void showMap(){
        for (Cha cha: map.keySet()){
            System.out.println(map.get(cha));
        }
    }
}
