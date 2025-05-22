package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public interface ModDimension {
    RegistryKey<World> ETERNAL_POOLS = create("eternal_pools");

    static RegistryKey<World> create(String id) {
        return RegistryKey.of(RegistryKeys.WORLD, EternalPools.id(id));
    }

    static void init() {
        // Dimensions are Registered Statically
    }
}
