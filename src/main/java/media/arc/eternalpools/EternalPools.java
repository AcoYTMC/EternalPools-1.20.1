package media.arc.eternalpools;

import eu.midnightdust.lib.config.MidnightConfig;
import media.arc.eternalpools.compat.PoolsConfig;
import media.arc.eternalpools.init.*;
import net.acoyt.pinecone.api.PineLib;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EternalPools implements ModInitializer {
	public static final String MOD_ID = "eternalpools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		PineLib.init(MOD_ID);
		PineLib.registerModMenu(MOD_ID, PoolsConfig.poolsNameColor);

		MidnightConfig.init(MOD_ID, PoolsConfig.class);

		ModBlocks.init();
		ModDimension.init();
		ModEnchantments.init();
		ModEntities.init();
		ModItems.init();
		ModParticles.init();
		ModSounds.init();
		ModStatusEffects.init();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}