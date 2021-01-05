package models.services;

import models.function.Input;
import models.function.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VillaManager {
    private Regex regex = new Regex();
    private Input input = new Input();
    private boolean status;
    private List<Villa> list;

    public VillaManager() {
        list = new ArrayList<>();
    }

    private String IdVilla() {
        if (!list.isEmpty()) {
            int temp = Integer.parseInt(list.get(0).getId().substring(5, 9));
            String tempString;
            for (int index = 0; index < list.size() - 1; index++) {
                if (Integer.parseInt(list.get(index).getId().substring(5, 9)) < Integer.parseInt(list.get(index + 1).getId().substring(5, 9))) {
                    temp = Integer.parseInt(list.get(index + 1).getId().substring(5, 9));
                }
            }
            temp++;
            if (temp >= 1000) {
                tempString = "SVVL-" + temp;
            } else if (temp >= 100) {
                tempString = "SVVL-0" + temp;
            } else if (temp >= 10) {
                tempString = "SVVL-00" + temp;
            } else {
                tempString = "SVVL-000" + temp;
            }
            return tempString;
        } else {
            return "SVVL-0001";
        }
    }

    public void addNewVilla() {
        String id = IdVilla();
        System.out.println("Input Villa's name:");
        String name = regex.regexServiceName();
        System.out.println("Input Villa's area:");
        double area = regex.regexAreaAndPoolArea();
        System.out.println("Input Villa's price:");
        double price = regex.regexPrice();
        System.out.println("Input Villa's maxPeople:");
        int maxPeople = regex.regexMaxPeople();
        System.out.println("Input Villa's rentType:");
        String date = regex.regexRentType();
        System.out.println("Input Villa's roomStandard:");
        String roomStandard = regex.regexRoomStandard();
        System.out.println("Input Villa's roomFurniture:");
        String roomFurniture = regex.regexRoomFurniture();
        System.out.println("Input Villa's poolArea:");
        double poolArea = regex.regexAreaAndPoolArea();
        System.out.println("Input Villa's floors:");
        int floors = regex.regexFloors();
        Villa villa = new Villa(id, name, area, price, maxPeople, date, roomStandard, roomFurniture, poolArea, floors);
        writeVilla(villa);
        list.add(villa);
    }

    public void displayVilla() {
        for (Villa villa : list) {
            System.out.println(villa.showInfo());
        }
    }

    public void displayNotDuplicateNameVilla() {
        Set<String> listNotDuplicateName = new TreeSet<>();
        for (Villa villa : list) {
            listNotDuplicateName.add(villa.getName());
        }
        System.out.println(listNotDuplicateName);
    }

    public void writeVilla(Villa villa) {
        try {
            writeVillaCheck(villa);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeVillaCheck(Villa villa) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/Villa.csv", true));
        bufferedWriter.write(villa.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void readVilla() {
        try {
            readVillaCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readVillaCheck() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/data/Villa.csv"));
        String line;
        String[] lineInfo;
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            list.add(new Villa(
                    lineInfo[0],
                    lineInfo[1],
                    Double.parseDouble(lineInfo[2]),
                    Double.parseDouble(lineInfo[3]),
                    Integer.parseInt(lineInfo[4]),
                    lineInfo[5],
                    lineInfo[6],
                    lineInfo[7],
                    Double.parseDouble(lineInfo[8]),
                    Integer.parseInt(lineInfo[9]))
            );
        }
    }

    public void showListInfoVilla() {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(index + "." + list.get(index).showInfo());
        }
    }

    public Villa getVillaByIndex() {
        Villa villa = null;
        do {
            try {
                status = true;
                int index = input.inputInt();
                villa = getVillaByIndexCheck(index);
            } catch (NullPointerException e) {
                status = false;
                System.err.println("Villa not exist");
            }
        } while (!status);
        return villa;
    }

    public Villa getVillaByIndexCheck(int index) {
        Villa villa = null;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                villa = list.get(i);
            }
        }
        if (villa == null) {
            throw new NullPointerException();
        }
        return villa;
    }

    public void containVillaList(String str) {
        List<Villa> listTemp = new ArrayList<>();
        for (Villa villa : list) {
            if (villa.getName().contains(str)) {
                listTemp.add(villa);
            }
        }
        for (int index = 0; index < listTemp.size(); index++) {
            System.out.println(index + ". " + listTemp.get(index).getId() + ", " + listTemp.get(index).getName());
        }
        containVilla(listTemp);
    }

    private void containVilla(List<Villa> listTemp) {
        do {
            try {
                status = true;
                containVillaCheck(listTemp);
            } catch (NullPointerException e) {
                status = false;
                System.err.println("No Villa found");
            }
        } while (!status);
    }

    private void containVillaCheck(List<Villa> listTemp) {
        int index;
        Villa villa = null;
        System.out.println("Input index, input -1 to out:");
        if (listTemp.isEmpty()) {
            System.out.println("No Villa found");
        } else {
            index = input.inputInt();
            if (index == -1) {
                return;
            }
            for (int i = 0; i < listTemp.size(); i++) {
                if (i == index) {
                    villa = listTemp.get(index);
                    break;
                }
            }
        }
        System.out.println(villa.showInfo());
    }

    public void deleteVilla() {
        showListInfoVilla();
        System.out.println("Input index, input -1 to out:");
        do {
            try {
                status = true;
                int index = input.inputInt();
                if (index == -1){
                    return;
                }
                deleteVillaCheck(index);
            } catch (IOException e) {
                status = false;
                System.err.println("File not found");
            } catch (NullPointerException e) {
                status = false;
                System.err.println("Wrong input, input again or -1 to out:");
            }
        } while (!status);
    }

    private void deleteVillaCheck(int index) throws IOException {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (i == index) {
                    list.remove(i);
                    i = 0;
                    break;
                }
                if (i == list.size() - 1){
                    i = 0;
                    throw new NullPointerException();
                }
            }
        }
        writeList();
    }

    private void writeList() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/Villa.csv"));
        for (Villa villa : list) {
            bufferedWriter.write(villa.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
