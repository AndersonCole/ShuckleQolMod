package ca.shuckle.state;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.PersistentState;

public class ModPersistentState extends PersistentState {
    private boolean oxidizeFaster = false;

    public boolean getOxidizeFaster() {
        return oxidizeFaster;
    }

    public void setOxidizeFaster(boolean newVal) {
        this.oxidizeFaster = newVal;
        markDirty();
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putBoolean("oxidizeFaster", oxidizeFaster);
        return nbt;
    }

    public static ModPersistentState createFromNbt(NbtCompound nbt) {
        ModPersistentState state = new ModPersistentState();
        state.oxidizeFaster = nbt.getBoolean("oxidizeFaster");
        return state;
    }
}
