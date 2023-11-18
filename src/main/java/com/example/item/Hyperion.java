package com.example.item;

import java.util.List;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
//import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
//import net.minecraft.util.

public class Hyperion extends SwordItem {
    public Hyperion(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material,attackDamage,attackSpeed,settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        int radius = 5;
        playerEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        world.addParticle(ParticleTypes.EXPLOSION, playerEntity.getX(), playerEntity.getY() + 1, playerEntity.getZ(), 0.0, 0.0, 0.0);
        //playerEntity.damage(DamageTypes.GENERIC,1);
        Box box = new Box(
                playerEntity.getX() - radius, playerEntity.getY() - radius, playerEntity.getZ() - radius,
                playerEntity.getX() + radius, playerEntity.getY() + radius, playerEntity.getZ() + radius
            );
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,50,1));
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, box, entity -> true);
        for(int i=0;i<entities.size();i++)
        {
            LivingEntity ient = entities.get(i);
            if (ient instanceof PlayerEntity == false) {
                //ient.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 5000, 1));
                RegistryKey<DamageType> dmg = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("generic"));
                DamageSource dmgsrc = new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(dmg));
                //Damagesource dmgsrc = DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
                ient.damage(dmgsrc, 10f);
                //ient.setHealth(ient.getHealth() - 3);
            }
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
