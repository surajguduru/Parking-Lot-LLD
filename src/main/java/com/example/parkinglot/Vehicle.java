public class Vehicle {
    private String vehicleNumber;
    private SlotType slotType;

    public Vehicle(String vehicleNumber, SlotType slotType) {
        this.vehicleNumber = vehicleNumber;
        this.slotType = slotType;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public SlotType getSlotType() {
        return this.slotType;
    }
}
