package bai3_Array.Bai_tap.e1_xoa_phan_tu;
import java.util.Scanner;
public class DeleteArr {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9, 0, 0, 0};
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        del_Arr(arr);
        System.out.println("-----");
        for (int value : arr) {
            System.out.print(value + "\t");
        }
    }
    public static void del_Arr(int[] array){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa: ");
        int delArr = scanner.nextInt();
        for (int i = 0; i < array.length; i++){
            if(delArr == array[i]){
                for (; i < array.length - 1; i++){
                    array[i] = array[i + 1];
                }
                break;
            }
        }
    }
}
