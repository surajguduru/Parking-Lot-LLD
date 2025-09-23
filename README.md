# Parking Lot Class Diagram 

```mermaid
classDiagram
class ParkingLot {
    - slots
    - entryGates
    - exitGates
    - strategy
    + getAvailableSlot()
}

class ParkingSlot {
    - slotId
    - type
    - occupied
    - distanceFromGate
    + getDistanceFrom()
    + occupy()
    + vacate()
}

class EVChargable {
    - slot
    + occupy()
    + vacate()
    + chargeVehicle()
}

class Vehicle {
    - vehicleNumber
    - type
}

class Ticket {
    - ticketId
    - vehicle
    - slot
    - entryTime
}

interface SlotSelectionStrategy
SlotSelectionStrategy : +findSlot()

class NearestSlotStrategy
NearestSlotStrategy : +findSlot()

class EntryGate {
    + generateTicket()
}

class ExitGate {
    + processExit()
}

class SlotType {
    <<enumeration>>
    SMALL
    MEDIUM
    LARGE
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
