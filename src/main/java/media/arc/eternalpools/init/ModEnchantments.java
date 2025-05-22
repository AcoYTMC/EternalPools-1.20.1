package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import media.arc.eternalpools.enchantment.EmptyEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModEnchantments {
    Map<Enchantment, Identifier> ENCHANTMENTS = new LinkedHashMap<>();

    //Enchantment TEST = createEnchantment("test", new EmptyEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment createEnchantment(String name, Enchantment enchantment) {
        ENCHANTMENTS.put(enchantment, EternalPools.id(name));
        return enchantment;
    }

    static void init() {
        ENCHANTMENTS.keySet().forEach((enchantment) -> {
            Registry.register(Registries.ENCHANTMENT, ENCHANTMENTS.get(enchantment), enchantment);
        });
    }
}
