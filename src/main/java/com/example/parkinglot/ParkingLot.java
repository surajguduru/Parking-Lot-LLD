import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingSlot> parkingSlots;
    SlotSelectionStrategy slotSelectionStrategy;
    List<EntryGate> entryGates;
    List<ExitGate> exitGates;
    Map<ParkingSlot, Ticket> activeTickets;

    public ParkingLot(List<ParkingSlot> parkingSlots, SlotSelectionStrategy slotSelectionStrategy, List<EntryGate> entryGates, List<ExitGate> exitGates) {
        this.parkingSlots = parkingSlots;
        this.slotSelectionStrategy = slotSelectionStrategy;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        activeTickets = new HashMap<>();
    }


    public ParkingSlot getAvailableParkingSlot(SlotType slotType, EntryGate entryGate) {
        return slotSelectionStrategy.getSlot(slotType, entryGate);
    } 

    public Ticket assignSlot(Vehicle vehicle, EntryGate entryGate) {
        ParkingSlot slot = getAvailableParkingSlot(vehicle.getSlotType(), entryGate);
        if(slot == null) {
            return null;
        }
        Ticket ticket = new Ticket(vehicle, slot, new Date());
        slot.occupySlot(vehicle, ticket);
        activeTickets.put(slot, ticket);
        return ticket;
    }

    public void vacateSlot(Ticket ticket) {
        ticket.setExitTime(new Date());
        ticket.getSlot().vacateSlot();
        activeTickets.remove(ticket.getSlot());
    }
}
