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

    private static void sortAscending(){
        list.sortByAscendingPrice();
    }

    private static void sortDescending(){
        list.sortByDescendingPrice();
    }

    public static void main(String[] args) {
        int num = 0;
        list.addProduct(new Product(1,"a",5));
        list.addProduct(new Product(2,"b",4));
        list.addProduct(new Product(3,"c",3));
        list.addProduct(new Product(4,"d",2));
        list.addProduct(new Product(5,"e",1));
    while (num != 8 ){
        System.out.println();
        System.out.println("" +
                "1. Show Product" + "\n" +
                "2. Add Product" + "\n" +
                "3. Set Product" + "\n" +
                "4. Remove Product" + "\n" +
                "5. Find Product" + "\n" +
                "6. Sort Ascending Price" + "\n" +
                "7. Sort Descending Price" + "\n" +
                "8. Quit" + "\n" +
                "Input:");
        num = Integer.parseInt(scanner.nextLine());
        switch (num){
            case 1:
                show();
                break;
            case 2:
                add();
                break;
            case 3:
                set();
                break;
            case 4:
                remove();
                break;
            case 5:
                find();
                break;
            case 6:
                sortAscending();
                break;
            case 7:
                sortDescending();
                break;
            case 8:
                System.out.println("Quit");
                break;
            default:
                System.out.println("False input");
        }
    }
    }
}
