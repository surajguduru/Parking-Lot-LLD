public class EVChargable extends ParkingSlot {

    private ParkingSlot wrappedSlot;
    private double chargedUnits;

    public EVChargable(ParkingSlot slot) {
        super(slot.getSlotId(), slot.getSlotType(), slot.getDistancesFromEntryGates());
        this.wrappedSlot = slot;
        this.chargedUnits = 0.0;
    }

    @Override
    public void occupySlot(Vehicle vehicle, Ticket ticket) {
        wrappedSlot.occupySlot(vehicle, ticket);
    }

    @Override
    public void vacateSlot() {
        wrappedSlot.vacateSlot();
        chargedUnits = 0.0;
    }

    @Override
    public boolean isOccupied() {
        return wrappedSlot.isOccupied();
    }

    @Override
    public SlotType getSlotType() {
        return wrappedSlot.getSlotType();
    }

    @Override
    public int getSlotId() {
        return wrappedSlot.getSlotId();
    }

    @Override
    public Integer getDistanceFromEntryGate(EntryGate entryGate) {
        return wrappedSlot.getDistanceFromEntryGate(entryGate);
    }

    public void charge(double units) {
        if (wrappedSlot.getCurrentVehicle() != null) {
            chargedUnits += units;
            System.out.println("Charging vehicle " + wrappedSlot.getCurrentVehicle().getVehicleNumber() +
                               " for " + units + " units. Total charged: " + chargedUnits);
        } else {
            System.out.println("No vehicle to charge in this slot.");
        }
    }

    public double getChargedUnits() {
        return chargedUnits;
    }
}
