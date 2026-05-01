package ca.shuckle.mixin;

import ca.shuckle.util.ItemScattererAccessor;
import net.minecraft.util.ItemScatterer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemScatterer.class)
public class ItemScattererMixin implements ItemScattererAccessor {
}
