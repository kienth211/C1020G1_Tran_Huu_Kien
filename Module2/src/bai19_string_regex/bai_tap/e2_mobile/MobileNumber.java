package bai19_string_regex.bai_tap.e2_mobile;

public class MobileNumber {
    static String regex = "\\([0-9]{2}\\)-\\(0[0-9]{9}\\)";
    public static void main(String[] args) {
        String str1 = "(84)-(0978489648)";
        String str2 = "(a8)-(22222222)";
        String str3 = "(84)(0978489648)";
        System.out.println(str1.matches(regex));
        System.out.println(str2.matches(regex));
        System.out.println(str3.matches(regex));
    }
}
