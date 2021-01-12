package _models;

import _function.Input;
import _function.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifiedMobileManager {
    private Input input = new Input();
    private Regex regex = new Regex();
    private static List<VerifiedMobile> list;
    private boolean status;

    public VerifiedMobileManager() {
        list = new ArrayList<>();
    }

    public void addVMobile() {
        int id = idMobile();
        System.out.println("Nhap ten");
        String name = input.inputString();
        System.out.println("Nhap gia");
        double price = regex.regexPrice();
        System.out.println("Nhap so luong");
        int quantity = regex.regexQuantity();
        System.out.println("Nhap nha san xuat");
        String producer = input.inputString();
        System.out.println("Nhap so luong ngay bao hanh");
        int date = regex.regexDate();
        System.out.println("Nhap pham vi bao hanh");
        String area = regex.regexArea();
        VerifiedMobile verifiedMobile = new VerifiedMobile(id, name, price, quantity, producer, date, area);
        list.add(verifiedMobile);
        writeVerifiedMobile(verifiedMobile);
        System.out.println("Da them dien thoai thanh cong");
    }

    private int idMobile() {
        if (!list.isEmpty()) {
            int temp = list.get(0).getIdMobile();
            for (int index = 0; index < list.size() - 1; index++) {
                if (list.get(index).getIdMobile() < list.get(index + 1).getIdMobile()) {
                    temp = list.get(index + 1).getIdMobile();
                }
            }
            temp++;
            return temp;
        } else {
            return 1;
        }
    }

    public void readVerifiedMobile() {
        try {
            readVerifiedMobileCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readVerifiedMobileCheck() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/data/VerifiedMobile.csv"));
        String line;
        String[] lineInfo;
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            list.add(new VerifiedMobile(
                    Integer.parseInt(lineInfo[0]),
                    lineInfo[1],
                    Double.parseDouble(lineInfo[2]),
                    Integer.parseInt(lineInfo[3]),
                    lineInfo[4],
                    Integer.parseInt(lineInfo[5]),
                    lineInfo[6]));
        }
    }

    public void writeVerifiedMobile(VerifiedMobile verifiedMobile) {
        try {
            writeVerifiedMobileCheck(verifiedMobile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeVerifiedMobileCheck(VerifiedMobile verifiedMobile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/VerifiedMobile.csv", true));
        bufferedWriter.write(verifiedMobile.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void showListInfoVerifiedMobile() {
        for (VerifiedMobile verifiedMobile : list) {
            System.out.println(verifiedMobile.toString());
        }
    }

    public void deleteVerifiedMobile() {
        showListInfoVerifiedMobile();
        System.out.println("Nhap id dien thoai:");
        do {
            try {
                status = true;
                int id = input.inputInt();
                if (checkList(id)) {
                    System.out.println("Nhap Yes hoac No:");
                    String str = regex.regexYesNo();
                    if (str.equals("Yes")) {
                        deleteVerifiedMobileCheck(id);
                    } else if (str.equals("No")) {
                        return;
                    }
                } else {
                    System.out.println("Khong co dien thoai trong list");
                }
            } catch (IOException e) {
                status = false;
                System.err.println("File not found");
            } catch (IndexOutOfBoundsException e) {
                status = false;
                System.err.println("Id dien thoai khong ton tai, moi nhap lai:");
            } catch (NullPointerException e) {
                status = false;
                System.err.println("Id dien thoai khong ton tai, moi nhap lai:");
            }
        } while (!status);
    }

    private void deleteVerifiedMobileCheck(int id) throws IOException {
        for (VerifiedMobile verifiedMobile: list){
            if (id == verifiedMobile.getIdMobile()){
                list.remove(id - 1);
                break;
            }
        }
        writeList();
    }

    private void writeList() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/VerifiedMobile.csv"));
        for (VerifiedMobile verifiedMobile : list) {
            bufferedWriter.write(verifiedMobile.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private boolean checkList(int id) {
        if (!list.isEmpty()) {
            for (VerifiedMobile verifiedMobile: list){
                if (id == verifiedMobile.getIdMobile()){
                    return true;
                }
            }
        } else {
            return false;
        }
        throw new NullPointerException();
    }
}
