package models.services;

import models.function.Input;
import models.function.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HouseManager {
    private Regex regex = new Regex();
    private Input input = new Input();
    private boolean status;
    private List<House> list;

    public HouseManager() {
        list = new ArrayList<>();
    }

    public void addNewHouse() {
        System.out.println("Input House's id:");
        String id = regex.regexIdService();
        System.out.println("Input House's name:");
        String name = regex.regexServiceName();
        System.out.println("Input House's area:");
        double area = regex.regexAreaAndPoolArea();
        System.out.println("Input House's price:");
        double price = regex.regexPrice();
        System.out.println("Input House's maxPeople:");
        int maxPeople = regex.regexMaxPeople();
        System.out.println("Input House's rentType:");
        String date = regex.regexRentType();
        System.out.println("Input House's roomStandard:");
        String roomStandard = regex.regexRoomStandard();
        System.out.println("Input House's roomFurniture:");
        String roomFurniture = regex.regexRoomFurniture();
        System.out.println("Input House's floors:");
        int floors = regex.regexFloors();
        House House = new House(id, name, area, price, maxPeople, date, roomStandard, roomFurniture, floors);
        writeHouse(House);
        list.add(House);
    }

    public void displayHouse() {
        for (House House : list) {
            System.out.println(House.showInfo());
        }
    }

    public void displayNotDuplicateNameHouse() {
        Set<String> listNotDuplicateName = new TreeSet<>();
        for (House House : list) {
            listNotDuplicateName.add(House.getName());
        }
        System.out.println(listNotDuplicateName);
    }

    public void writeHouse(House House) {
        try {
            writeHouseCheck(House);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHouseCheck(House House) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/House.csv", true));
        bufferedWriter.write(House.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void readHouse() {
        try {
            readHouseCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readHouseCheck() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/data/House.csv"));
        String line;
        String[] lineInfo;
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            list.add(new House(
                    lineInfo[0],
                    lineInfo[1],
                    Double.parseDouble(lineInfo[2]),
                    Double.parseDouble(lineInfo[3]),
                    Integer.parseInt(lineInfo[4]),
                    lineInfo[5],
                    lineInfo[6],
                    lineInfo[7],
                    Integer.parseInt(lineInfo[8]))
            );
        }
    }

    public void showListInfoHouse() {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(index + "." + list.get(index).showInfo());
        }
    }

    public House getHouseByIndex() {
        House house = null;
        do {
            try {
                status = true;
                int index = input.inputInt();
                house = getHouseByIndexCheck(index);
            } catch (NullPointerException e){
                status = false;
                System.err.println("House not exist");
            }
        } while (!status);
        return house;
    }

    public House getHouseByIndexCheck(int index) {
        House house = null;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                house = list.get(i);
            }
        }
        if (house == null){
            throw new NullPointerException();
        }
        return house;
    }
}
