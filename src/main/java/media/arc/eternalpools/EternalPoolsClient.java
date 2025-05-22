package media.arc.eternalpools;

import media.arc.eternalpools.init.ModBlocks;
import media.arc.eternalpools.init.ModItems;
import media.arc.eternalpools.init.ModParticles;
import net.fabricmc.api.ClientModInitializer;

public class EternalPoolsClient implements ClientModInitializer {
	public void onInitializeClient() {
		ModBlocks.clientInit();
		ModItems.clientInit();
		ModParticles.registerFactories();
	}
}