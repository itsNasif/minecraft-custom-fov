package com.fovbreaker;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(FovBreaker.MOD_ID)
public class FovBreaker {
    public static final String MOD_ID = "fovbreaker";

    public FovBreaker() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, FovConfig.SPEC);
    }
}
