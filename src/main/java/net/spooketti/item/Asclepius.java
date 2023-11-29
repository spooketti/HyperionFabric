package net.spooketti.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Asclepius extends SwordItem {
    public Asclepius(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material,attackDamage,attackSpeed,settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        float currentHealth = playerEntity.getHealth();
        float maxHealth = playerEntity.getMaxHealth();
        playerEntity.setHealth(Math.min(maxHealth, currentHealth + (float) (maxHealth * .2)));
         world.addParticle(ParticleTypes.HEART, playerEntity.getX(), playerEntity.getY() + 1, playerEntity.getZ(), 0.0, 0.0, 0.0);
         playerEntity.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_PLACE, currentHealth, maxHealth);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
