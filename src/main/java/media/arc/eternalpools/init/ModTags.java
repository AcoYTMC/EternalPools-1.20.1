package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface ModTags {
    TagKey<EntityType<?>> HADOPELAGIC = createEntity("hadopelagic");

    private static TagKey<EntityType<?>> createEntity(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, EternalPools.id(id));
    }

    private static TagKey<Item> createItem(String id) {
        return TagKey.of(RegistryKeys.ITEM, EternalPools.id(id));
    }

    private static TagKey<Block> createBlock(String id) {
        return TagKey.of(RegistryKeys.BLOCK, EternalPools.id(id));
    }

    private static TagKey<Enchantment> createEnchantment(String id) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, EternalPools.id(id));
    }
}
