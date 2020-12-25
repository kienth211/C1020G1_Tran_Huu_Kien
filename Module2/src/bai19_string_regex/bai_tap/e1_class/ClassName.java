package bai19_string_regex.bai_tap.e1_class;

public class ClassName {
    static String regex = "[C|A|P][0-9]{4}[G|H|I|K|L|M]";
    public static void main(String[] args) {
        String str1 = "C1020G";
        String str2 = "a";
        System.out.println(str1.matches(regex));
        System.out.println(str2.matches(regex));
    }
}
