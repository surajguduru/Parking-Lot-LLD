import java.security.KeyStore.Entry;
import java.util.List;

public interface SlotSelectionStrategy {
    ParkingSlot getSlot(SlotType slotType, EntryGate entryGate);
}
