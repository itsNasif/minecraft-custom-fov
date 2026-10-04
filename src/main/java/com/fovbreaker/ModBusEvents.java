package com.fovbreaker;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = FovBreaker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusEvents {
    public static final String CATEGORY = "key.categories.fovbreaker";

    public static final KeyMapping INCREASE = new KeyMapping("key.fovbreaker.increase", GLFW.GLFW_KEY_RIGHT_BRACKET, CATEGORY);
    public static final KeyMapping DECREASE = new KeyMapping("key.fovbreaker.decrease", GLFW.GLFW_KEY_LEFT_BRACKET, CATEGORY);
    public static final KeyMapping RESET = new KeyMapping("key.fovbreaker.reset", GLFW.GLFW_KEY_BACKSLASH, CATEGORY);
    public static final KeyMapping TOGGLE = new KeyMapping("key.fovbreaker.toggle", GLFW.GLFW_KEY_UNKNOWN, CATEGORY);

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(INCREASE);
        event.register(DECREASE);
        event.register(RESET);
        event.register(TOGGLE);
    }
}
