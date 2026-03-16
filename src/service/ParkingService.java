package service;

import model.*;
import repository.*;

import java.time.*;
import java.util.*;

public class ParkingService extends ParkingProcess {

    private SlotRepository slotRepo;
    private SessionRepository sessionRepo;

    public ParkingService(SlotRepository slotRepo,SessionRepository sessionRepo){
        this.slotRepo = slotRepo;
        this.sessionRepo = sessionRepo;
    }

    public void displaySlots(){

        System.out.println("\n============== PARKING LOT ==============");

        List<ParkingSlot> slots = slotRepo.getSlots();

        for(int i=0;i<slots.size();i++){

            ParkingSlot s = slots.get(i);

            if(s.isAvailable())
                System.out.print("[ ] "+s.getSlotId()+"   ");
            else
                System.out.print("[X] "+s.getSlotId()+"   ");

            if((i+1)%5==0){
                System.out.println();
            }
        }
    }

    @Override
    public ParkingSession startParking(String userId,String slotId){

        ParkingSlot slot = slotRepo.findSlot(slotId);

        if(slot==null || !slot.isAvailable()){
            return null;
        }

        slot.setAvailable(false);

        ParkingSession session = new ParkingSession(
                UUID.randomUUID().toString(),
                userId,
                slotId,
                LocalDateTime.now()
        );

        sessionRepo.addSession(session);

        return session;
    }

    @Override
    public void endParking(ParkingSession session){

        ParkingSlot slot = slotRepo.findSlot(session.getSlotId());

        if(slot!=null){
            slot.setAvailable(true);
        }

        LocalDateTime end = LocalDateTime.now();

        long minutes = Duration.between(session.getStartTime(),end).toMinutes();

        int hours = (int)Math.ceil(minutes/60.0);

        int fee = calculateFee(hours);

        session.endSession(end,fee);

        System.out.println("\n------ Parking Summary ------");

        System.out.println("Slot ID: "+session.getSlotId());
        System.out.println("Start Time: "+session.getStartTime().toLocalTime());
        System.out.println("End Time: "+session.getEndTime().toLocalTime());
        System.out.println("Total Hours: "+hours);
        System.out.println("Total Fee: "+fee);
    }

    public int calculateFee(int hours){
        return hours*50;
    }

    public int calculateFee(int hours,String vehicleType){

        if(vehicleType.equalsIgnoreCase("SUV")){
            return hours*70;
        }

        return hours*50;
    }
}