package media.arc.eternalpools.mixin.client;

import media.arc.eternalpools.init.ModDimension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugHud.class)
public class DebugHudMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(
            method = "drawLeftText",
            at = @At("HEAD"),
            cancellable = true
    )
    private void disableLeftText(DrawContext context, CallbackInfo ci) {
        if (this.shouldDisable()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "drawRightText",
            at = @At("HEAD"),
            cancellable = true
    )
    private void disableRightText(DrawContext context, CallbackInfo ci) {
        if (this.shouldDisable()) {
            ci.cancel();
        }
    }

    @Unique
    private boolean shouldDisable() {
        if (this.client != null && !this.client.player.isCreative() && !this.client.player.isSpectator()) {
            return this.client.world.getRegistryKey() == ModDimension.ETERNAL_POOLS;
        } else {
            return false;
        }
    }
}
