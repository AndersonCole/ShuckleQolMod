package ca.shuckle.state;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentStateManager;

public class ModStateManager {
    public static ModPersistentState getServerState(MinecraftServer server) {
        PersistentStateManager manager = server.getOverworld().getPersistentStateManager();
        return manager.getOrCreate(ModPersistentState::createFromNbt, ModPersistentState::new, "shuckle_state");
    }
}
