package service;

import model.ParkingSession;

public abstract class ParkingProcess {

    public abstract ParkingSession startParking(String userId,String slotId);

    public abstract void endParking(ParkingSession session);

}