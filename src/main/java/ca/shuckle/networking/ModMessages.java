package ca.shuckle.networking;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.entity.custom.CrafterBlockEntity;
import ca.shuckle.screen.custom.CrafterScreenHandler;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModMessages {
    public static final Identifier SLOT_CHANGED = new Identifier(ShuckleQOL.MOD_ID, "slot_changed");

    public static void registerC2SMessages() {
        ServerPlayNetworking.registerGlobalReceiver(SLOT_CHANGED, ((server, player, handler, buf, responseSender) -> {
            int slotId = buf.readInt();
            BlockPos pos = buf.readBlockPos();
            boolean newState = buf.readBoolean();

            server.execute(() -> {
                BlockEntity blockEntity = player.getWorld().getBlockEntity(pos);
                if (!(blockEntity instanceof CrafterBlockEntity crafterBlockEntity)) return;

                crafterBlockEntity.setSlotEnabled(slotId, newState);

                if (player.currentScreenHandler instanceof CrafterScreenHandler crafterScreenHandler) {
                    crafterScreenHandler.setSlotEnabled(slotId, newState);
                    crafterScreenHandler.sendContentUpdates();
                }
            });
        }));
    }
}
