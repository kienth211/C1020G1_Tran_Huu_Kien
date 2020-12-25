package _test_;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;


public class Main {
    private static void regexBirthday(String date){
        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
        StringBuilder stringBuilder = new StringBuilder(date);
        int yearCustomer;
        if (date.matches(regex)){
            stringBuilder.delete(0,6);
            System.out.println(stringBuilder);
            yearCustomer = Integer.parseInt(stringBuilder.toString());
            if ((2020 - yearCustomer) > 18){
                System.out.println(">18");
            } else {
                System.out.println("<18");
            }
        } else {
            System.out.println("wrong");
        }
    }
    public static void main(String[] args) {
        regexBirthday("10/10/2010");
        regexBirthday("10/10/2000");
        regexBirthday("a");
//        plusA( 1, 2);
//    }
////    public static int plusA(long a, int b ){
////        return (int) (a + b);
////    }
//
//    public static int plusA(int a, long b ){
//        return (int) (a + b);
//        int randomNum = (int)(Math.random() * 4 + 2);  // 0 to 100
//        String str_a = "10/10/2010";
//        String str_b = "a/a/a";
//        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
//        System.out.println(str_a.matches(regex));
//        System.out.println(str_b.matches(regex));
//        StringBuilder stringBuilder = new StringBuilder(str_a);
//        char[] chars = new char[20];
//        stringBuilder.getChars(6,10,chars,0);
//        System.out.println(str_a);
//        System.out.println(chars);
////        System.out.println(randomNum);
//        LocalDate date = LocalDate.now();
//        System.out.println(date);
//        System.out.println(date.getYear());
    }
}
