import java.util.Date;

public class ExitGate {
    ParkingLot parkingLot;

    public ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    
    public void processExit(Ticket ticket) {
        this.parkingLot.vacateSlot(ticket);
    }
}
