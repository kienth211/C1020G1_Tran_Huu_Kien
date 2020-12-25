package bai11_queue_stack.bai_tap.e3_map;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    static Integer Value = 1;

    public static void main(String[] args) {
        Map<String, Integer> myMap = new TreeMap<>();
        String str = "Kien Son Thanh Dung Thanh Thinh Tuan";
        String[] strArr = str.split(" ");
        for (String a : strArr) {
            if (myMap.containsKey(a)) {
                myMap.put(a, myMap.get(a) + 1);
            } else {
                myMap.put(a, Value);
            }
        }
        System.out.println(myMap);
    }
}
