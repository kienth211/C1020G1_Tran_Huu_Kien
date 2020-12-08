package bai4_class.bai_tap.e2_stop_watch;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        int temp = 0;
        StopWatch check = new StopWatch();

        System.out.println(check.getStartTime());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100000);;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(check.getEndTime());
        System.out.println(check.getStartTimeLong());
        System.out.println(check.getEndTimeLong());
        System.out.println(check.calculator());
    }
}
