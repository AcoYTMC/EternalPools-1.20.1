package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModEntities {
    Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap<>();

    //EntityType<AllayEntity> TEST = createEntity("test", FabricEntityTypeBuilder.create(SpawnGroup.MISC, AllayEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).trackRangeChunks(128).build());

    private static <T extends EntityType<? extends Entity>> T createEntity(String name, T entity) {
        ENTITIES.put(entity, EternalPools.id(name));
        return entity;
    }

    static void init() {
        ENTITIES.keySet().forEach((entityType) -> {
            Registry.register(Registries.ENTITY_TYPE, ENTITIES.get(entityType), entityType);
        });
    }
}
