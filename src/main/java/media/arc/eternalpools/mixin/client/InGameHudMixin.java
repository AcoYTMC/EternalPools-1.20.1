package media.arc.eternalpools.mixin.client;

import media.arc.eternalpools.init.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getAttackIndicator()Lnet/minecraft/client/option/SimpleOption;"), cancellable = true)
    private void noAttackIndicator(DrawContext context, CallbackInfo ci) {
        MinecraftClient client = this.client;
        PlayerEntity player = client.player;
        if (player != null) {
            if (player.getMainHandStack().isOf(ModItems.DEPTH_TRACKER) || player.getOffHandStack().isOf(ModItems.DEPTH_TRACKER)) {
                ci.cancel();
            }
        }
    }
}
