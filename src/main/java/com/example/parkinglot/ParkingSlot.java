import java.util.Map;

public class ParkingSlot {
    private int slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private Vehicle currentVehicle;
    private Ticket currentTicket;
    private Map<EntryGate, Integer> distancesFromEntryGates;

    public ParkingSlot(int slotId, SlotType slotType, Map<EntryGate, Integer> distancesFromEntryGates) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.distancesFromEntryGates = distancesFromEntryGates;
        this.isOccupied = false;
        this.currentVehicle = null;
        this.currentTicket = null;
    }

    public ParkingSlot() {
        
    }

    public int getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public Map<EntryGate, Integer> getDistancesFromEntryGates() {
        return distancesFromEntryGates;
    }

    public Integer getDistanceFromEntryGate(EntryGate entryGate) {
        return distancesFromEntryGates.get(entryGate);
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public void setDistancesFromEntryGates(Map<EntryGate, Integer> distancesFromEntryGates) {
        this.distancesFromEntryGates = distancesFromEntryGates;
    }

    public void occupySlot(Vehicle vehicle, Ticket ticket) {
        this.currentVehicle = vehicle;
        this.currentTicket = ticket;
        this.isOccupied = true;
    }

    public void vacateSlot() {
        this.currentVehicle = null;
        this.currentTicket = null;
        this.isOccupied = false;
    }
}
