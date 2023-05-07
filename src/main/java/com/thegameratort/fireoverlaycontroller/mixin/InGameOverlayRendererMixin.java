package com.thegameratort.fireoverlaycontroller.mixin;

import com.thegameratort.fireoverlaycontroller.FireOverlayController;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(InGameOverlayRenderer.class)
public abstract class InGameOverlayRendererMixin {
    @ModifyArg(
        method = "renderFireOverlay(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/util/math/MatrixStack;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/VertexConsumer;color(FFFF)Lnet/minecraft/client/render/VertexConsumer;"
        ),
        index = 3
    )
    private static float renderFireOverlayOpacity(float alpha) {
        return FireOverlayController.getConfig().fireOpacity;
    }

    @ModifyArg(
        method = "renderFireOverlay(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/util/math/MatrixStack;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
        ),
        index = 1
    )
    private static float renderFireOverlayTranslate(float y) {
        return -1.0F + FireOverlayController.getConfig().fireHeight;
    }
}
