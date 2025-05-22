package media.arc.eternalpools.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import media.arc.eternalpools.EternalPools;

public class PoolComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<DivingSuitComponent> DIVING_SUIT = ComponentRegistry.getOrCreate(EternalPools.id("diving_suit"), DivingSuitComponent.class);

    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(DIVING_SUIT, DivingSuitComponent::new, RespawnCopyStrategy.NEVER_COPY);
    }

    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        //
    }
}
