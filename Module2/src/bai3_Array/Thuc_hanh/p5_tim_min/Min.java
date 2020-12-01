package bai3_Array.Thuc_hanh.p5_tim_min;

public class Min {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index] + " Index: " + index);
    }

    public static int minValue(int[] array){
        int i = 0;
        int min = array[0];
        int index = 0;
        for (; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
