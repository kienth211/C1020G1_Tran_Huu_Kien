package bai12_java_collection_framework.bai_tap.e1_product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagementByArrList {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Product> myArrList;

    public ProductManagementByArrList() {
        myArrList = new ArrayList<>();
    }

    public void addProduct(Product product){
        myArrList.add(product);
    }

    public void displayProduct(){
        for (Product product: myArrList) {
            System.out.println(product);
        }
    }
    public void removeProduct(int id){
        Product product = getProductById(id);
        if (product == null){
            System.out.println("Not found");
            return;
        }
        myArrList.remove(product);
    }

    public void findProductByName(String name){
        Product product = getProductByName(name);
        if (product == null){
            System.out.println("Not found");
        }
        System.out.println("Sản phẩm là: " + product);
    }

    public void setProductInfoById(int id){
        Product product = getProductById(id);
        if (product == null){
            System.out.println("Not found");
        }
        System.out.println("Nhập Id: ");
        int id_1 = Integer.parseInt(scanner.nextLine());
        product.setId(id_1);
        System.out.println("Nhập Name: ");
        String name = scanner.nextLine();
        product.setName(name);
        System.out.println("Nhập Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        product.setPrice(price);
        System.out.println("Sản phẩm vừa sửa: " + product);
    }

    Comparator priceSort = new PriceSort();


    private Product getProductById(int id){
        for (Product product: myArrList){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    private Product getProductByName(String name){
        for (Product product: myArrList){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
}
