package net.spooketti;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.text.Text;

public class KeyBind implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
    KeyBinding stickyBinding = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding("key.spooketti.ultimate", GLFW.GLFW_KEY_R, "key.category.spooketti.spooketticategory", () -> true));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {

			if (stickyBinding.wasPressed()) {
				client.player.sendMessage(Text.literal(":("));
			}
		});
	}
}