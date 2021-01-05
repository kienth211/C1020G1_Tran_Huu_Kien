package models.services;

import models.function.Input;
import models.function.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RoomManager {
    private Regex regex = new Regex();
    private Input input = new Input();
    private boolean status;
    private List<Room> list;

    public RoomManager() {
        list = new ArrayList<>();
    }

    public void addNewRoom() {
        System.out.println("Input Room's id:");
        String id = regex.regexIdService();
        System.out.println("Input Room's name:");
        String name = regex.regexServiceName();
        System.out.println("Input Room's area:");
        double area = regex.regexAreaAndPoolArea();
        System.out.println("Input Room's price:");
        double price = regex.regexPrice();
        System.out.println("Input Room's maxPeople:");
        int maxPeople = regex.regexMaxPeople();
        System.out.println("Input Room's rentType:");
        String date = regex.regexRentType();
        System.out.println("Input Room's freeService:");
        String freeService = regex.regexFreeService();
        Room room = new Room(id, name, area, price, maxPeople, date, freeService);
        writeRoom(room);
        list.add(room);
    }

    public void displayRoom() {
        for (Room room : list) {
            System.out.println(room.showInfo());
        }
    }

    public void displayNotDuplicateNameRoom() {
        Set<String> listNotDuplicateName = new TreeSet<>();
        for (Room room : list) {
            listNotDuplicateName.add(room.getName());
        }
        System.out.println(listNotDuplicateName);
    }

    public void writeRoom(Room room) {
        try {
            writeRoomCheck(room);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeRoomCheck(Room room) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/data/Room.csv", true));
        bufferedWriter.write(room.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void readRoom() {
        try {
            readRoomCheck();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readRoomCheck() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/data/Room.csv"));
        String line;
        String[] lineInfo;
        while ((line = bufferedReader.readLine()) != null) {
            lineInfo = line.split(",");
            list.add(new Room(
                    lineInfo[0],
                    lineInfo[1],
                    Double.parseDouble(lineInfo[2]),
                    Double.parseDouble(lineInfo[3]),
                    Integer.parseInt(lineInfo[4]),
                    lineInfo[5],
                    lineInfo[6])
            );
        }
    }

    public void showListInfoRoom() {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(index + "." + list.get(index).showInfo());
        }
    }

    public Room getRoomByIndex() {
        Room room = null;
        do {
            try {
                status = true;
                int index = input.inputInt();
                room = getRoomByIndexCheck(index);
            } catch (NullPointerException e){
                status = false;
                System.err.println("Room not exist");
            }
        } while (!status);
        return room;
    }

    public Room getRoomByIndexCheck(int index) {
        Room room = null;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                room = list.get(i);
            }
        }
        if (room == null){
            throw new NullPointerException();
        }
        return room;
    }
}
