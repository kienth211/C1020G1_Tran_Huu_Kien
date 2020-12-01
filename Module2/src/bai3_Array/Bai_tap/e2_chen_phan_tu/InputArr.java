package bai3_Array.Bai_tap.e2_chen_phan_tu;

import java.util.Scanner;
public class InputArr {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9, 0, 0, 0};
        int []arr_2 = new int[arr.length + 1];

        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "\t");
        }

        input_Arr(arr,arr_2);

        System.out.println("-----");
        for (int value : arr_2) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");
        for (int i = 0; i < arr_2.length; i++) {
            System.out.print(i + "\t");
        }
    }
    public static void input_Arr(int[] array,int[] array_2){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Nhập vị trí chèn phần tử : ");
        int indexInput = scanner.nextInt();
        System.out.println("Nhập phần tử cần chèn : ");
        int input = scanner.nextInt();
        for (int i = 0, j = 0; i < array.length; i++,j++){
            if (i == indexInput){
                array_2[j] = input;
                j++;
            }
            array_2[j] = array[i];
        }
    }
}
