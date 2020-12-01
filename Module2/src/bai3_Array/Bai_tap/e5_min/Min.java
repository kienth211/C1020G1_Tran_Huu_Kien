package bai3_Array.Bai_tap.e5_min;

public class Min {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9, 17, 5, 25};
        int min = arr[0];
        int min_index = 0;
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
                min_index = i;
            }
        }
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");
        System.out.println("Min: " + min + " Index: " + min_index);
    }
}
