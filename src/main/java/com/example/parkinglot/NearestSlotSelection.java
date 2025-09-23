import java.util.*;

public class NearestSlotSelection implements SlotSelectionStrategy {

    private final List<ParkingSlot> parkingSlots;

    public NearestSlotSelection(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    @Override
    public ParkingSlot getSlot(SlotType slotType, EntryGate gate) {
        Collections.sort(parkingSlots, Comparator.comparingInt(slot -> slot.getDistanceFromEntryGate(gate)));

        for (ParkingSlot slot : parkingSlots) {
            if (slot.getSlotType() == slotType && !slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }
}
