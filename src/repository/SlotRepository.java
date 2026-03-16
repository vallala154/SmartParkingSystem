package repository;

import model.ParkingSlot;
import java.util.*;

public class SlotRepository {

    private List<ParkingSlot> slots = new ArrayList<>();

    public SlotRepository(){

        String[] rows = {"A","B","C","D"};

        for(String row : rows){
            for(int i=1;i<=5;i++){
                slots.add(new ParkingSlot(row+i));
            }
        }
    }

    public List<ParkingSlot> getSlots(){
        return slots;
    }

    public ParkingSlot findSlot(String id){

        for(ParkingSlot s : slots){
            if(s.getSlotId().equalsIgnoreCase(id)){
                return s;
            }
        }

        return null;
    }
}