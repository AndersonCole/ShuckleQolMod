package ca.shuckle.screen.custom;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.networking.ModMessages;
import ca.shuckle.screen.custom.slot.CrafterInputSlot;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CrafterScreen extends HandledScreen<CrafterScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(ShuckleQOL.MOD_ID, "textures/gui/container/crafter.png");
    private static final Text TOGGLEABLE_SLOT_TEXT = Text.translatable("crafter.gui.toggleable_slot");
    private final PlayerEntity player;

    public CrafterScreen(CrafterScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title);
        this.player = playerInventory.player;
    }

    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    protected void onSlotChangedState(int slotId, int handlerId, boolean newState) {
        if (this.client == null || this.client.world == null) return;

        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(slotId);
        buffer.writeBlockPos(this.handler.getPos());
        buffer.writeBoolean(newState);

        ClientPlayNetworking.send(
                ModMessages.SLOT_CHANGED,
                buffer);
    }

    private void setSlotState(int slotId, boolean enabled) {
        this.handler.setSlotEnabled(slotId, enabled);
        this.onSlotChangedState(slotId, this.handler.syncId, enabled);
        float f = enabled ? 1.0f : 0.75f;
        this.player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 0.4f, f);
    }

    protected void onMouseClick(Slot slot, int slotId, int button, SlotActionType actionType) {
        if (slot instanceof CrafterInputSlot && (slotId > -1 && slotId < 9) && !slot.hasStack() && !this.player.isSpectator()) {
            switch (actionType) {
                case PICKUP:
                    if (this.handler.isSlotDisabled(slotId)) {
                        this.setSlotState(slotId, true);
                        return;
                    } else if (this.handler.getCursorStack().isEmpty()) {
                        this.setSlotState(slotId, false);
                        return;
                    }
                    break;
                case SWAP:
                    ItemStack itemStack = this.player.getInventory().getStack(button);
                    if (this.handler.isSlotDisabled(slotId) && !itemStack.isEmpty()) {
                        this.setSlotState(slotId, true);
                        return;
                    }
            }
        }

        super.onMouseClick(slot, slotId, button, actionType);
    }

    public void drawDisabledSlot(MatrixStack matrices, CrafterInputSlot slot) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        CrafterScreen.drawTexture(matrices, slot.x - 1, slot.y - 1, 177, 3, 18, 18);
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawArrowTexture(matrices);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);

        if (this.focusedSlot instanceof CrafterInputSlot && !this.handler.isSlotDisabled(this.focusedSlot.id) && this.handler.getCursorStack().isEmpty() && !this.focusedSlot.hasStack()) {
            this.renderTooltip(matrices, TOGGLEABLE_SLOT_TEXT, mouseX, mouseY);
        }

    }

    private void drawArrowTexture(MatrixStack matrices) {
        int i = this.width / 2 + 9;
        int j = this.height / 2 - 48;
        RenderSystem.setShaderTexture(0, TEXTURE);
        if (this.handler.isTriggered()){
            CrafterScreen.drawTexture(matrices, i, j, 177, 22, 16, 16);
        } else {
            CrafterScreen.drawTexture(matrices, i, j, 177, 39, 16, 16);
        }
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        RenderSystem.setShaderTexture(0, TEXTURE);
        CrafterScreen.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
