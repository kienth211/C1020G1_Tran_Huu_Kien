package models;

import java.util.ArrayList;
import java.util.List;

public class VillaManager {
    private List<Villa> list;
    private boolean status = true;

    public VillaManager() {
        list = new ArrayList<>();
    }

    public void addNewService(Villa villa){
        list.add(villa);
    }

    public void displayVilla(){
        for (Villa villa: list){
            System.out.println(villa.showInfo());
        }
    }

    public void displayNotDuplicateNameVilla(){
        List<String> listNotDuplicateName = new ArrayList<>();
        for (Villa villa: list){
            for (String villaDup: listNotDuplicateName){
                if(villa.getName().equals(villaDup)){
                    status = false;
                    break;
                }
            }
            if (status){
                listNotDuplicateName.add(villa.getName());
            }
            status = true;
        }
        System.out.println(listNotDuplicateName);
    }
}
