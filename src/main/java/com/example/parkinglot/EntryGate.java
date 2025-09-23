public class EntryGate {

    private ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        Ticket ticket = parkingLot.assignSlot(vehicle, this);
        if (ticket == null) {
            throw new RuntimeException("No available slot!");
        }
        return ticket;
    }
}
