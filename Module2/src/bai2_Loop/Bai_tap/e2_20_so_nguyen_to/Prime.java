package bai2_Loop.Bai_tap.e2_20_so_nguyen_to;

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
            if (check) {
                System.out.print(number + " ");
                count++;
            }
            if (count > 20) {
                break;
            }
            i = 2;
            check = true;
        }
    }
}