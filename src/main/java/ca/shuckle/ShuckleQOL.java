package ca.shuckle;

import ca.shuckle.block.ModBlocks;
import ca.shuckle.item.ModItemGroup;
import ca.shuckle.item.ModItems;
import ca.shuckle.util.ModPointsOfInterest;
import ca.shuckle.util.ModRegistries;
import ca.shuckle.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShuckleQOL implements ModInitializer {
	public static final String MOD_ID = "shuckle_qol";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//Middle Clicking and CRTL+H'ing on functions/properties
		//is a very good to see and copy vanilla source code
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuff();

		ModWorldGen.generateModWorldGen();

		//ModEnchantments.registerModEnchantments();

		ModPointsOfInterest.registerModPOIs();
	}
}
