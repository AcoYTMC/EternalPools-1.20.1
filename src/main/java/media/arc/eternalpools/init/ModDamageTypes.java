package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ModDamageTypes {
    RegistryKey<DamageType> EEL = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, EternalPools.id("eel"));
}
