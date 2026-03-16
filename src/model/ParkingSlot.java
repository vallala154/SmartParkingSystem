package model;

public class ParkingSlot {
	 private String slotId;
	    private boolean available;

	    public ParkingSlot(String slotId) {
	        this.slotId = slotId;
	        this.available = true;
	    }

	    public String getSlotId() {
	        return slotId;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }
}
