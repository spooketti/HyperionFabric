package net.spooketti;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mod implements ModInitializer {

	public static final String MODID = "spooketti";
	
	public Identifier LAST_ULT = new Identifier(MODID,"last_ult");
	
	@Override
	public void onInitialize() {
		ModItems.registerItems();

	}
	
}