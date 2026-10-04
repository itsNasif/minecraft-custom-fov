package com.fovbreaker;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FovBreaker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    /** Replace the FOV, keeping sprint/potion/spyglass effects by scaling proportionally. */
    @SubscribeEvent
    public static void onComputeFov(ViewportEvent.ComputeFov event) {
        if (!FovConfig.ENABLED.get()) return;
        if (!event.usedConfiguredFov()) return; // leave hand FOV etc. alone

        double base = Minecraft.getInstance().options.fov().get();
        if (base <= 0) return;

        double target = FovConfig.CUSTOM_FOV.get();
        double result = event.getFOV() * (target / base);
        event.setFOV(Math.max(1.0, Math.min(179.0, result)));
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        int step = FovConfig.STEP.get();

        while (ModBusEvents.INCREASE.consumeClick()) {
            setFov(mc, FovConfig.CUSTOM_FOV.get() + step);
        }
        while (ModBusEvents.DECREASE.consumeClick()) {
            setFov(mc, FovConfig.CUSTOM_FOV.get() - step);
        }
        while (ModBusEvents.RESET.consumeClick()) {
            setFov(mc, 70);
        }
        while (ModBusEvents.TOGGLE.consumeClick()) {
            boolean now = !FovConfig.ENABLED.get();
            FovConfig.ENABLED.set(now);
            FovConfig.ENABLED.save();
            mc.player.displayClientMessage(
                    Component.literal("FOV Breaker: " + (now ? "ON" : "OFF")), true);
        }
    }

    private static void setFov(Minecraft mc, int value) {
        int v = Math.max(1, Math.min(179, value));
        FovConfig.CUSTOM_FOV.set(v);
        FovConfig.CUSTOM_FOV.save();
        mc.player.displayClientMessage(Component.literal("FOV: " + v), true);
    }
}
