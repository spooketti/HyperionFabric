package net.spooketti.armor;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class MageStat {

    public static void ultimate(PlayerEntity player)
    {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,30000));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,30000));
    }
    
}
