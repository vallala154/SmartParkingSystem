package model;

import java.time.LocalDateTime;

public class ParkingSession {

    private String sessionId;
    private String userId;
    private String slotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int totalFee;

    public ParkingSession(String sessionId, String userId, String slotId, LocalDateTime startTime) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.slotId = slotId;
        this.startTime = startTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSlotId() {
        return slotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void endSession(LocalDateTime endTime, int fee) {
        this.endTime = endTime;
        this.totalFee = fee;
    }
}