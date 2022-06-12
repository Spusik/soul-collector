package soulcollector.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import soulcollector.api.armor.ArmorEffectRegistry;
import soulcollector.event.SoulCollectorEvents;

import java.util.Arrays;

@Mixin(StatusEffectUtil.class)
public class StatusEffectUtilMixin {

    @Inject(method = "durationToString", at = @At("HEAD"), cancellable = true)
    private static void durationToString(StatusEffectInstance effect, float multiplier, CallbackInfoReturnable<String> cir){

        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if(player != null){
            ArmorEffectRegistry.getArmorEffects().forEach((armorEffect) -> {
                if(Arrays.equals(SoulCollectorEvents.getArmorAsList(player), armorEffect.getArmorAsList())){
                    if(armorEffect.getStatusEffect() != null && effect.getEffectType().equals(armorEffect.getStatusEffect())){
                        cir.setReturnValue(armorEffect.getName());
                    }
                }
            });
        }
    }
}