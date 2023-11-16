package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.item.ToolItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.item.Hyperion;
import com.example.toolmaterial.EndCrystalMaterial;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final ToolItem HYPERION = new Hyperion(EndCrystalMaterial.INSTANCE, 5, -2.4F, new FabricItemSettings().rarity(Rarity.EPIC));

	/*private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
	.icon(() -> new ItemStack(HYPERION))
	.displayName(Text.translatable("itemGroup.tutorial.test_group"))
        .entries((context, entries) -> {
		entries.add(HYPERION);
	})
	.build();*/
/* 
	
	private static void addItems(FabricItemGroupEntries entries)
	{
		entries.add(HYPERION);
	}

	public static void registerModItems()
	{
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ExampleMod::addItems);
	}*/
	
	
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("tutorial","hyperion"), HYPERION);
		
	}
}