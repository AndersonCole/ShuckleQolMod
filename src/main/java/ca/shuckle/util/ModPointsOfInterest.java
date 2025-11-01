package ca.shuckle.util;

import ca.shuckle.ShuckleQOL;
import ca.shuckle.block.ModBackportBlocks;
import ca.shuckle.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

public class ModPointsOfInterest {
    public static final PointOfInterestType OXIDIZABLE_LIGHTNING_ROD =
            registerPOI("oxidizable_lightning_rod_poi", 0, 1, ModBackportBlocks.LIGHTNING_ROD);
    public static final PointOfInterestType EXPOSED_LIGHTNING_ROD =
            registerPOI("exposed_lightning_rod_poi", 0, 1, ModBackportBlocks.EXPOSED_LIGHTNING_ROD);
    public static final PointOfInterestType WEATHERED_LIGHTNING_ROD =
            registerPOI("weathered_lightning_rod_poi", 0, 1, ModBackportBlocks.WEATHERED_LIGHTNING_ROD);
    public static final PointOfInterestType OXIDIZED_LIGHTNING_ROD =
            registerPOI("oxidized_lightning_rod_poi", 0, 1, ModBackportBlocks.OXIDIZED_LIGHTNING_ROD);
    public static final PointOfInterestType WAXED_EXPOSED_LIGHTNING_ROD =
            registerPOI("waxed_exposed_lightning_rod_poi", 0, 1, ModBackportBlocks.WAXED_EXPOSED_LIGHTNING_ROD);
    public static final PointOfInterestType WAXED_WEATHERED_LIGHTNING_ROD =
            registerPOI("waxed_weathered_lightning_rod_poi", 0, 1, ModBackportBlocks.WAXED_WEATHERED_LIGHTNING_ROD);
    public static final PointOfInterestType WAXED_OXIDIZED_LIGHTNING_ROD =
            registerPOI("waxed_oxidized_lightning_rod_poi", 0, 1, ModBackportBlocks.WAXED_OXIDIZED_LIGHTNING_ROD);
    public static final PointOfInterestType INVIS_LIGHTNING_ROD =
            registerPOI("invisible_lightning_rod_poi", 0, 1, ModBlocks.INVIS_LIGHTNING_ROD);

    private static PointOfInterestType registerPOI(String name, int ticketCount, int searchDistance, Block block){
        return PointOfInterestHelper.register(new Identifier(ShuckleQOL.MOD_ID, name), ticketCount, searchDistance,
                ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerModPOIs() {

    }
}
