package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.acoyt.pinecone.item.ported.TTBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlocks {
    Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

    static <T extends Block> T createBlock(String name, T block, boolean createItem) {
        BLOCKS.put(block, EternalPools.id(name));
        if (createItem) {
            ModItems.createItem(name, new TTBlockItem(block, new Item.Settings()));
        }
        return block;
    }

    static void init() {
        BLOCKS.keySet().forEach((block) -> {
            Registry.register(Registries.BLOCK, BLOCKS.get(block), block);
        });
    }

    static void clientInit() {
        //
    }
}
