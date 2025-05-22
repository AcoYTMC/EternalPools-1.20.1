package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import media.arc.eternalpools.effect.EmptyStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModStatusEffects {
    Map<StatusEffect, Identifier> EFFECTS = new LinkedHashMap<>();

    //StatusEffect FEAR = create("fear", new EmptyStatusEffect(StatusEffectCategory.HARMFUL, 0xF7F7F7));

    private static <T extends StatusEffect> T create(String name, T effect) {
        EFFECTS.put(effect, EternalPools.id(name));
        return effect;
    }

    static void init() {
        EFFECTS.keySet().forEach((effect) -> {
            Registry.register(Registries.STATUS_EFFECT, EFFECTS.get(effect), effect);
        });
    }
}
