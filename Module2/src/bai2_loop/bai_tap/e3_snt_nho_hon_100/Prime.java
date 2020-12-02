package bai2_loop.bai_tap.e3_snt_nho_hon_100;

public class Prime {
    public static void main(String[] args) {
        int i = 2;
        boolean check = true;
        for (int number = 2,count = 0; number < 100; number++) {
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.print(number + " ");
            i = 2;
            check = true;
        }
    }
}
