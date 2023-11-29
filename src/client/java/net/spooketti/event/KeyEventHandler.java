package net.spooketti.event;

import org.lwjgl.glfw.GLFW;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.text.Text;

public class KeyEventHandler implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KeyBinding stickyBinding = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding("key.fabric-key-binding-api-v1-modid.test_keybinding_sticky", GLFW.GLFW_KEY_X, "key.category.first.test", () -> true));

		ClientTickEvents.END_CLIENT_TICK.register(client ->
        {
            if(stickyBinding.isPressed())
            {
                System.out.println("this is so scary");
                client.player.sendMessage(Text.literal("WTF"));

            }
        });
	}
}