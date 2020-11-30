package bai1_Introduction_to_Java.bai_tap.e3_Money;

import java.util.Scanner;

public class Money {
    static int vnd;
    static void toVnd(int usd){
        vnd = usd * 23000;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số USD");
        int usd = scanner.nextInt();
        toVnd(usd);
        System.out.println(vnd + " Việt Nam Đồng");
    }
}
