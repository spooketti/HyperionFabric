package net.spooketti.armor;

import net.spooketti.armormaterial.ModArmor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FullSet extends ArmorItem{

    public FullSet(ArmorMaterial material, Type type, Settings settings)
    {
        super(material,type,settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient())
        {
            if(entity instanceof PlayerEntity player && isFullSet(player))
            {
                fullSetBonus(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean correctArmor(PlayerEntity player, ArmorMaterial material)
    {
        for(ItemStack armorStack : player.getInventory().armor)
        {
            if(!(armorStack.getItem() instanceof ArmorItem))
            {
                return false;
            }
        }
        ArmorItem bootSlot = (ArmorItem)player.getInventory().getArmorStack(0).getItem();
        ArmorItem legSlot = (ArmorItem)player.getInventory().getArmorStack(1).getItem();
        ArmorItem chestSlot = (ArmorItem)player.getInventory().getArmorStack(2).getItem();
        ArmorItem headSlot = (ArmorItem)player.getInventory().getArmorStack(3).getItem();
        //System.out.println(bootSlot.getMaterial() == material && chestSlot.getMaterial() == material && legSlot.getMaterial() == material && headSlot.getMaterial() == material);
        return bootSlot.getMaterial() == material && chestSlot.getMaterial() == material && legSlot.getMaterial() == material && headSlot.getMaterial() == material;
    }

    private boolean isFullSet(PlayerEntity player)
    {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void fullSetBonus(PlayerEntity player)
    {
        //boolean hasPlayerEffect = player.hasStatusEffect(StatusEffects.GLOWING));
        if(correctArmor(player, ModArmor.MAGEINSTANCE) && !player.hasStatusEffect(StatusEffects.GLOWING)) 
        {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 400));
        }
    }
}
