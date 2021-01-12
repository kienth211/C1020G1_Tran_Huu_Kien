package _test_;

import java.util.ArrayList;
import java.util.List;

public class Main_4 {
    private int a = 1;
    private String id;

    public Main_4(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private static void add(int a){
        a = a + 1;
        System.out.println(a);
    }

    private static void addStr(String b){
        b.toUpperCase();
    }


    public static void main(String[] args) {
//        List<Main_4> list = new ArrayList<>();
//        Main_4 main_1 = new Main_4("SVVL-0001");
//        Main_4 main_2 = new Main_4("SVVL-0002");
//        list.add(main_1);
//        list.add(main_2);
//        String str1;
//        String str2;
//        str1 = list.get(0).getId().substring(5,9);
//        System.out.println(str1);
        String b = new String("abc");
        int a = 1;
        add(a);
        addStr(b);
        System.out.println(a);
        System.out.println(b);
    }
}
