package media.arc.eternalpools.init;

import media.arc.eternalpools.EternalPools;
import media.arc.eternalpools.item.DepthTracker;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModItems {
    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    Item DEPTH_TRACKER = createItem("depth_tracker", new DepthTracker(new Item.Settings()));

    static <T extends Item> T createItem(String name, T item) {
        ITEMS.put(item, EternalPools.id(name));
        return item;
    }

    static void init() {
        ITEMS.keySet().forEach((item) -> {
            Registry.register(Registries.ITEM, ITEMS.get(item), item);
        });
    }

    static void clientInit() {
        HudRenderCallback.EVENT.register(((context, delta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            PlayerEntity player = client.player;
            GameOptions gameOptions = client.options;
            if (player != null) {
                if (gameOptions.getPerspective().isFirstPerson()) {
                    if (client.interactionManager != null && client.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
                        if (player.getOffHandStack().isOf(DEPTH_TRACKER) || player.getMainHandStack().isOf(DEPTH_TRACKER)) {
                            int pos = client.player.getBlockPos().getY();
                            int i = 27;

                            if (pos > 99) {
                                i = 34;
                            }

                            if (pos < 10) {
                                i = 22;
                            }

                            if (pos < 0) {
                                i = 27;
                            }

                            if (pos < -9) {
                                i = 34;
                            }

                            if (pos < -99) {
                                i = 41;
                            }

                            context.drawText(client.textRenderer, Text.literal("[ " + client.player.getBlockPos().getY() + " ]"), (context.getScaledWindowWidth() - i) / 2, (context.getScaledWindowHeight() + 10) / 2, 0x386a50, true);
                        }
                    }
                }
            }
        }));
    }
}
