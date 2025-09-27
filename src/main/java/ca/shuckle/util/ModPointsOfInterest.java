package ca.shuckle.util;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.mixin.object.builder.PointOfInterestTypeAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.HashSet;
import java.util.Set;

public class ModPointsOfInterest {
    public static final PointOfInterestType INVIS_LIGHTNING_ROD =
            registerPOI("invisible_lightning_rod_poi", 0, 1, ModBlocks.INVIS_LIGHTNING_ROD);

    private static PointOfInterestType registerPOI(String name, int ticketCount, int searchDistance, Block block){
        return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(ShuckleQOL.MOD_ID, name),
                PointOfInterestTypeAccessor.callCreate(name,
                        ImmutableSet.copyOf(block.getStateManager().getStates()), ticketCount, searchDistance));
    }

    public static void registerModPOIs() {
        PointOfInterestTypeAccessor.callSetup(INVIS_LIGHTNING_ROD);
    }
}
