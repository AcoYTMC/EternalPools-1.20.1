package media.arc.eternalpools.cca;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class DivingSuitComponent implements AutoSyncedComponent {
    private final PlayerEntity player;
    private boolean wearingDivingSuit;

    public static DivingSuitComponent get(PlayerEntity player) {
        return (DivingSuitComponent) PoolComponents.DIVING_SUIT.get(player);
    }

    public DivingSuitComponent(PlayerEntity player) {
        this.player = player;
        this.wearingDivingSuit = false;
    }

    public boolean isWearingDivingSuit() {
        return this.wearingDivingSuit;
    }

    public void setWearingDivingSuit(boolean wearingDivingSuit) {
        this.wearingDivingSuit = wearingDivingSuit;
    }

    public void readFromNbt(NbtCompound nbt) {
        this.wearingDivingSuit = nbt.getBoolean("wearingDivingSuit");
    }

    public void writeToNbt(NbtCompound nbt) {
        nbt.putBoolean("wearingDivingSuit", this.wearingDivingSuit);
    }
}
