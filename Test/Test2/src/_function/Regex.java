package _function;

import java.util.List;

public class Regex {
    private Input input = new Input();
    private boolean status = true;
public double regexPrice(){
    double price;
    do {
        if (!status) {
            System.err.println("Gia phai > 0, nhap lai:");
        }
        price = input.inputDouble();
        status = price > 0;
    } while (!status);
    return price;
}

    public int regexQuantity(){
        int quantity;
        do {
            if (!status) {
                System.err.println("So luong phai > 0, nhap lai:");
            }
            quantity = input.inputInt();
            status = quantity > 0;
        } while (!status);
        return quantity;
    }

    public int regexDate(){
        int date;
        do {
            if (!status) {
                System.err.println("Ngay bao hanh phai > 0 va < 731 ngay, nhap lai:");
            }
            date = input.inputInt();
            status = date > 0 && date < 731;
        } while (!status);
        return date;
    }

    public String regexArea() {
        String regex = "(Toan Quoc|Quoc Te)";
        String area;
        do {
            area = input.inputString();
            status = area.matches(regex);
            if (!status) {
                System.err.println("Khong dung dinh dang, nhap lai:");
            }
        } while (!status);
        return area;
    }

    public String regexYesNo() {
        String regex = "(Yes|No)";
        String yes;
        do {
            yes = input.inputString();
            status = yes.matches(regex);
            if (!status) {
                System.err.println("Khong dung dinh dang, nhap lai:");
            }
        } while (!status);
        return yes;
    }
}
