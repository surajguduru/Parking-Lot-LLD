import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Map<EntryGate, Integer> distances = new HashMap<>(); // keeping empty at first
            SlotType type = (i % 3 == 0) ? SlotType.LARGE : (i % 3 == 1) ? SlotType.SMALL : SlotType.MEDIUM;
            slots.add(new ParkingSlot(i, type, distances));
        }

        List<EntryGate> entryGates = new ArrayList<>();
        List<ExitGate> exitGates = new ArrayList<>();
        NearestSlotSelection strategy = new NearestSlotSelection(slots);
        ParkingLot parkingLot = new ParkingLot(slots, strategy, entryGates, exitGates);

        EntryGate gate1 = new EntryGate(parkingLot);
        EntryGate gate2 = new EntryGate(parkingLot);
        entryGates.addAll(Arrays.asList(gate1, gate2));

        ExitGate exitGate = new ExitGate(parkingLot);
        exitGates.add(exitGate);

        slots.forEach(slot -> {
            slot.getDistancesFromEntryGates().put(gate1, rand.nextInt(50));
            slot.getDistancesFromEntryGates().put(gate2, rand.nextInt(50));
        });


        Vehicle v1 = new Vehicle("KA01A1234", SlotType.SMALL);
        Vehicle v2 = new Vehicle("KA02B5678", SlotType.MEDIUM);

        Ticket t1 = gate1.generateTicket(v1);
        System.out.println("Ticket issued: " + t1);

        Ticket t2 = gate2.generateTicket(v2);
        System.out.println("Ticket issued: " + t2);

        exitGate.processExit(t1);
        exitGate.processExit(t2);
    }
}
