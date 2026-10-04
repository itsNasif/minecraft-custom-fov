package com.fovbreaker;

import net.minecraftforge.common.ForgeConfigSpec;

public class FovConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue ENABLED;
    public static final ForgeConfigSpec.IntValue CUSTOM_FOV;
    public static final ForgeConfigSpec.IntValue STEP;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        b.push("fov");
        ENABLED = b.comment("Enable the FOV limit breaker.")
                .define("enabled", true);
        CUSTOM_FOV = b.comment("Your custom FOV (1 - 179). Vanilla slider is limited to 30 - 110.")
                .defineInRange("customFov", 120, 1, 179);
        STEP = b.comment("How much the FOV changes per key press.")
                .defineInRange("step", 5, 1, 30);
        b.pop();
        SPEC = b.build();
    }
}
