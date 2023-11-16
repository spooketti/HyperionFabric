package com.example.item;

//import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
//import net.minecraft.util.

public class Hyperion extends SwordItem {
    public Hyperion(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material,attackDamage,attackSpeed,settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        /* how to makae damge work pls
        float radius = 5.0f;
        DamageSource dmg = DamageSource.GENERIC;
        if(playerEntity != null && playerEntity.getServer() != null) {
            Box box = new Box(
                playerEntity.getX() - radius, playerEntity.getY() - radius, playerEntity.getZ() - radius,
                playerEntity.getX() + radius, playerEntity.getY() + radius, playerEntity.getZ() + radius
            );

           playerEntity.getServer().getWorld(playerEntity.getWorld().getRegistryKey()).getEntitiesByClass(Entity.class, box, entity ->{
            if(entity instanceof LivingEntity && !(entity instanceof PlayerEntity)) {
               return true;
            }
            return false;
           }).forEach(entity -> {
            ((LivingEntity) entity).damage(DamageSource.thrownProjectile(this,this.getOwner(),5.0f);
           });
        }
        */
        playerEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        world.addParticle(ParticleTypes.EXPLOSION, playerEntity.getX(), playerEntity.getY() + 1.0, playerEntity.getZ(), 0.0, 0.0, 0.0);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
