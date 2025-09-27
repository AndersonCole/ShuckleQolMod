package ca.shuckle.util;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPointsOfInterest {
    public static final PointOfInterestType INVIS_LIGHTNING_ROD =
            registerPOI("invisible_lightning_rod_poi", 0, 1, ModBlocks.INVIS_LIGHTNING_ROD);

    private static PointOfInterestType registerPOI(String name, int ticketCount, int searchDistance, Block block){
        return Registry.register(Registries.POINT_OF_INTEREST_TYPE, new Identifier(ShuckleQOL.MOD_ID, name),
                new PointOfInterestType(ImmutableSet.copyOf(block.getStateManager().getStates()), ticketCount, searchDistance));
    }

    public static void registerModPOIs() {

    }
}
