package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.armormaterial.EndCrystalArmorMaterial;
import com.example.item.Asclepius;
import com.example.item.Hyperion;
import com.example.toolmaterial.EndCrystalToolMaterial;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
   
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final ToolItem HYPERION = new Hyperion(EndCrystalToolMaterial.INSTANCE, 5, -2.4F, new FabricItemSettings().rarity(Rarity.EPIC));
	public static final ToolItem ASCLEPIUS = new Asclepius(ToolMaterials.GOLD, 1, -2.4F, new FabricItemSettings().rarity(Rarity.RARE));
	public static final ArmorItem MAGEHELMET = new ArmorItem(EndCrystalArmorMaterial.INSTANCE,ArmorItem.Type.HELMET,new FabricItemSettings());
	public static final ArmorItem MAGECHEST = new ArmorItem(EndCrystalArmorMaterial.INSTANCE,ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
	public static final ArmorItem MAGELEG = new ArmorItem(EndCrystalArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
	public static final ArmorItem MAGEBOOT = new ArmorItem(EndCrystalArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static void registerCreative(RegistryKey<ItemGroup> igroup, Item after, Item item)
	{
	ItemGroupEvents.modifyEntriesEvent(igroup).register(content -> {
			content.addAfter(after, item);
		});
	}

	
     public static void registerItems()
    {
        Registry.register(Registries.ITEM, new Identifier("tutorial","hyperion"), HYPERION);
		Registry.register(Registries.ITEM, new Identifier("tutorial","asclepius"), ASCLEPIUS);
        Registry.register(Registries.ITEM, new Identifier("tutorial","mage_helmet"),MAGEHELMET);
		Registry.register(Registries.ITEM, new Identifier("tutorial","mage_chestplate"),MAGECHEST);
		Registry.register(Registries.ITEM, new Identifier("tutorial","mage_leggings"),MAGELEG);
		Registry.register(Registries.ITEM, new Identifier("tutorial","mage_boots"),MAGEBOOT);
		registerCreative(ItemGroups.COMBAT, Items.NETHERITE_SWORD, ASCLEPIUS);
		registerCreative(ItemGroups.COMBAT,Items.NETHERITE_SWORD,HYPERION);
    }
}
