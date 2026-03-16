package repository;

import model.ParkingSession;
import java.util.*;

public class SessionRepository {

    private List<ParkingSession> sessions = new ArrayList<>();

    public void addSession(ParkingSession session){
        sessions.add(session);
    }

    public List<ParkingSession> getSessionsByUser(String userId){

        List<ParkingSession> list = new ArrayList<>();

        for(ParkingSession s : sessions){
            if(s.getUserId().equals(userId)){
                list.add(s);
            }
        }

        return list;
    }
}