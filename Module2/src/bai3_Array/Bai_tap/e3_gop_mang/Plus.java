package bai3_Array.Bai_tap.e3_gop_mang;

public class Plus {
    public static void main(String[] args) {
        int []arr_1 = {1, 2, 3, 4, 5, 6};
        int []arr_2 = {7, 8, 9, 10};
        int []arr_3 = new int[arr_1.length + arr_2.length];
        plus_Arr(arr_1,arr_2,arr_3);
    }
    public static void plus_Arr(int[] array_1,int[] array_2,int[] array_3){
        for (int value : array_1) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");
        for (int value : array_2) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");
        for (int i = 0,j = 0; i < array_1.length; i++,j++){
            array_3[j] = array_1[i];
            if (i == array_1.length - 1){
                j++;
                for (i = 0; i < array_2.length; i++,j++){
                    array_3[j] = array_2[i];
                }
                break;
            }

        }
        for (int value : array_3) {
            System.out.print(value + "\t");
        }
        System.out.println(" ");

    }
}
