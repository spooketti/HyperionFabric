package com.example.toolmaterial;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EndCrystalMaterial implements ToolMaterial{

    public static final EndCrystalMaterial INSTANCE = new EndCrystalMaterial();

    @Override
    public int getDurability()
    {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 1;
    }

    @Override
    public int getEnchantability()
    {
        return 22;
    }

    @Override
    public float getAttackDamage()
    {
        return 3.0F;
    }

    @Override
    public int getMiningLevel()
    {
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
     return Ingredient.ofItems(Items.OBSIDIAN);   
    }

    
    
}
