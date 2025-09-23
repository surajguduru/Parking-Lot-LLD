# Parking Lot Class Diagram 

```mermaid
classDiagram
class ParkingLot {
    - List<ParkingSlot> slots
    - List<EntryGate> entryGates
    -List<ExitGate> exitGates
    - SlotSelectionStrategy strategy
    +getAvailableSlot() ParkingSlot
}

class ParkingSlot {
    - int slotId
    - SlotType type
    - boolean occupied
    - Map<EntryGate, Integer> distanceFromGate
    +getDistanceFrom(EntryGate) int
    +occupy()
    +vacate()
}

class EVChargable {
    - ParkingSlot slot
    +occupy()
    +vacate()
    +chargeVehicle()
}

class Vehicle {
    - String vehicleNumber
    - SlotType type
}

enum SlotType {
    SMALL
    MEDIUM
    LARGE
}

class Ticket {
    - String ticketId
    - Vehicle vehicle
    - ParkingSlot slot
    - Date entryTime
}

interface SlotSelectionStrategy {
    +findSlot(List<ParkingSlot>) ParkingSlot
}

class NearestSlotStrategy {
    +findSlot(List<ParkingSlot>) ParkingSlot
}

class EntryGate {
    +generateTicket(Vehicle) Ticket
}

class ExitGate {
    +processExit(Ticket)
}

%% Relationships
ParkingLot "1" *-- "many" ParkingSlot : contains
ParkingLot "1" o-- "many" EntryGate : has
ParkingLot "1" o-- "many" ExitGate : has
ParkingLot "1" --> SlotSelectionStrategy : uses
SlotSelectionStrategy <|.. NearestSlotStrategy
Ticket --> Vehicle : isIssuedFor
Ticket --> ParkingSlot : isAssignedTo
EVChargable --|> ParkingSlot : decorates
Vehicle --> SlotType
ParkingSlot --> SlotType
