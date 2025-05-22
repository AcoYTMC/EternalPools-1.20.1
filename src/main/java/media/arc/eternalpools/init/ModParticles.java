package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.NoteParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModParticles {
    Map<ParticleType<?>, Identifier> PARTICLES = new LinkedHashMap<>();

    //DefaultParticleType TEST = create("test", FabricParticleTypes.simple(true));

    private static <T extends ParticleType<?>> T create(String name, T particle) {
        PARTICLES.put(particle, EternalPools.id(name));
        return particle;
    }

    static void init() {
        PARTICLES.keySet().forEach((particle) -> {
            Registry.register(Registries.PARTICLE_TYPE, PARTICLES.get(particle), particle);
        });
    }

    static void registerFactories() {
        //ParticleFactoryRegistry.getInstance().register(TEST, NoteParticle.Factory::new);
    }
}
