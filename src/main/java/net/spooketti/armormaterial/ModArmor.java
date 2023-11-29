package net.spooketti.armormaterial;

import com.google.common.base.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModArmor implements ArmorMaterial{
	MAGEINSTANCE("mage",1,new int[] {3,8,6,3},22,SoundEvents.ENTITY_WITHER_AMBIENT,2f,0.1f, () -> Ingredient.ofItems(Items.OBSIDIAN)),
	TANKINSTANCE("tank",1,new int[] {3,8,6,3},22,SoundEvents.ENTITY_WITHER_AMBIENT,2f,0.1f, () -> Ingredient.ofItems(Items.OBSIDIAN));
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float kbResistance;
	private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};

	ModArmor(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float kbResistance, Supplier<Ingredient> repairIngredient)
	{
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.kbResistance = kbResistance;
		this.repairIngredient = repairIngredient;
	}
 
	@Override
	public int getEnchantability() {
		return this.enchantability;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
 
	@Override
	public String getName() {
		// Must be all lowercase
		return "spooketti:"+this.name;
	}
 
	@Override
	public float getToughness() {
		return this.toughness;
	}
 
	@Override
	public float getKnockbackResistance() {
		return this.kbResistance;
	}

	@Override
	public int getProtection(ArmorItem.Type type)
	{
		return this.protectionAmounts[type.ordinal()];
	}

	public int getDurability(ArmorItem.Type type)
	{
		return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier; 
	}

	
    
    
}
