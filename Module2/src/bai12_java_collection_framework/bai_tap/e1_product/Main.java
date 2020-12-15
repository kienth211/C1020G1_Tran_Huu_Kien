package bai12_java_collection_framework.bai_tap.e1_product;

import java.util.Scanner;

public class Main {
    private static final ProductManagementByArrList list = new ProductManagementByArrList();
    private static final Scanner scanner = new Scanner(System.in);

    private static void add(){
        System.out.println("Nhap id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap name:");
        String name = scanner.nextLine();
        System.out.println("Nhap price:");
        int price = Integer.parseInt(scanner.nextLine());
        list.addProduct(new Product(id,name,price));
    }

    private static void show(){
        list.displayProduct();
    }

    private static void remove(){
        System.out.println("Nhap Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        list.removeProduct(id);
    }
    private static void set(){
        System.out.println("Nhap Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        list.setProductInfoById(id);
    }
    private static void find(){
        System.out.println("Nhập name: ");
        String name = scanner.nextLine();
        list.findProductByName(name);
    }
    public static void main(String[] args) {
        list.addProduct(new Product(1,"a",5));
        list.addProduct(new Product(2,"b",4));
        list.addProduct(new Product(3,"c",3));
        list.addProduct(new Product(4,"d",2));
        list.addProduct(new Product(5,"e",1));
//        add();
//        add();
//        add();
//        show();
//        remove();
//        show();
//        find();
        show();
        set();
        show();
//        list.displayProduct();
    }
}
