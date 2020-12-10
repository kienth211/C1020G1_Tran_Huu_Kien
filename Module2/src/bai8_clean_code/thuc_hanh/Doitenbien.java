package bai8_clean_code.thuc_hanh;

public class Doitenbien {
    public static void main(String[] args) {
        System.out.println(calculate(1,2,ADDITION));
        System.out.println(calculate(1,2,SUBTRACTION));
        System.out.println(calculate(1,2,MULTIPLICATION));
        System.out.println(calculate(1,2,DIVISION));
    }
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static double calculate(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
