package bai1_Introduction_to_Java.bai_tap.e2_Number;

import java.util.Scanner;
public class Number<Static, unit> {
    private static String unit,tens,hundred;
    static void units(int number){
        switch (number){
            case 0:
                unit = "Zero";
                break;
            case 1:
                unit = "One";
                break;
            case 2:
                unit = "Two";
                break;
            case 3:
                unit = "Three";
                break;
            case 4:
                unit = "Four";
                break;
            case 5:
                unit = "Five";
                break;
            case 6:
                unit = "Six";
                break;
            case 7:
                unit = "Sven";
                break;
            case 8:
                unit = "Eight";
                break;
            case 9:
                unit = "Nine";
                break;
            case 10:
                unit = "Ten";
                break;
            case 11:
                unit = "Eleven";
                break;
            case 12:
                unit = "Twelve";
                break;
            case 13:
                unit = "Thirteen";
                break;
            case 14:
                unit = "Fourteen";
                break;
            case 15:
                unit = "Fifteen";
                break;
            case 16:
                unit = "Sixteen";
                break;
            case 17:
                unit = "Seventeen";
                break;
            case 18:
                unit = "Eighteen";
                break;
            case 19:
                unit = "Nineteen";
                break;
            case 20:
                unit = "Twenty";
                break;
            default:
                unit = "";
        }
    }
    static void tensOf(int number){
        switch (number){
            case 20:
                tens = "Twenty";
                break;
            case 30:
                tens = "Thirty";
                break;
            case 40:
                tens = "Forty";
                break;
            case 50:
                tens = "Fifty";
                break;
            case 60:
                tens = "Sixty";
                break;
            case 70:
                tens = "Seventy";
                break;
            case 80:
                tens = "Eighty";
                break;
            case 90:
                tens = "Ninety";
                break;
            default:
                tens = "";
        }
    }
    static void hundredsOf(int number){
        switch (number){
            case 100:
                hundred = "One Hundred";
                break;
            case 200:
                hundred = "Two Hundred";
                break;
            case 300:
                hundred = "Three Hundred";
                break;
            case 400:
                hundred = "Four Hundred";
                break;
            case 500:
                hundred = "Five Hundred";
                break;
            case 600:
                hundred = "Six Hundred";
                break;
            case 700:
                hundred = "Sven Hundred";
                break;
            case 800:
                hundred = "Eight Hundred";
                break;
            case 900:
                hundred = "Nine Hundred";
                break;
            default:
                hundred = "";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int unit_1;
        int tens_1;
        int hundred_1;
        System.out.print("Nhập số:");
        number = scanner.nextInt();
        if (number > 999 || number < 0){
            System.out.println("Bạn nhập sai định dạng");
        }
        if (number <= 20){
            units(number);
            System.out.println(unit);
        }
        if (number > 20 && number < 100){
            unit_1 = number % 10;
            tens_1 = number - unit_1;
            units(unit_1);
            tensOf(tens_1);
            System.out.println(tens + " " + unit);
        }
        if (number >= 100 && number < 1000){
            tens_1 = number % 100;
            if (tens_1 <= 20){
                hundred_1 = number - tens_1;
                hundredsOf(hundred_1);
                units(tens_1);
                System.out.println(hundred + " and " + unit);
            }
            else {
                hundred_1 = number - tens_1;
                unit_1 = tens_1 % 10;
                tens_1 = tens_1 - unit_1;
                units(unit_1);
                tensOf(tens_1);
                hundredsOf(hundred_1);
                System.out.println(hundred + " and " + tens + " " + unit);
            }
        }
    }

}
