package _test_;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_4 {
    private int a = 1;
    private String id;

    public Main_4(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

//    private static void add(int a){
//        a = a + 1;
//        System.out.println(a);
//    }

//    private static void addStr(String b){
//        b.toUpperCase();
//    }


    public static void main(String[] args) {
        List<Main_4> list = new ArrayList<>();
        Map<Main_4, Integer> map = new HashMap<>();
        Main_4 main_1 = new Main_4("SVVL-0001");
        Main_4 main_2 = new Main_4("SVVL-0002");
        Main_4 main_3 = new Main_4("SVVL-0003");
        list.add(main_1);
        list.add(main_2);
        list.add(main_3);
        list.add(main_1);
        list.add(main_1);
        list.add(main_3);
//        map.put(main_1, 1);
//        map.put(main_1, 1);
//        for (Main_4 main_4: list) {
//            map.put(main_4, 1);
//        }
        for (Main_4 main_4: list) {
            if (map.containsKey(main_4)) {
                map.put(main_4, map.get(main_4) + 1);
            } else {
                map.put(main_4, 1);
            }
        }
        list.clear();
        list.addAll(map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()));
        Collections.reverse(list);


//        String str1;`
//        String str2;
//        str1 = list.get(0).getId().substring(5,9);
//        System.out.println(str1);
//        String b = new String("abc");
//        int a = 1;
//        add(a);
//        addStr(b);
//        System.out.println(a);
//        System.out.println(b);
        for (Main_4 main_4: list){
            System.out.println(main_4.getId());
        }

        System.out.println(map);
    }
}
