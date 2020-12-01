package bai3_Array.Bai_tap.e4_max_2_chieu;

public class Max {
    public static void main(String[] args) {
        int [][]arr_1 = {{1,2,3,4,5}, {16,17,18,19,20}, {6,7,8,9,10}, {11,12,13,14,15}};
        int max,max_row,max_col;
        max = arr_1[0][0];
        max_row = 0;
        max_col = 0;
        for (int row = 0; row < arr_1.length; row++){
            for (int col = 0; col < arr_1[row].length; col++){
                System.out.print(arr_1[row][col] + "\t");
                if (arr_1[row][col] > max){
                    max = arr_1[row][col];
                    max_row = row;
                    max_col = col;
                }
                if (col == arr_1[row].length - 1){
                    System.out.println(" ");
                }
            }
        }
        System.out.println("Phần tử lớn nhất: " + max);
        System.out.println("Index, row: " + (max_row + 1) + " col: " + (max_col + 1));
    }
}
