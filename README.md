# FOV Limit Breaker (Forge 1.20.4)

Break the vanilla FOV slider limit (30-110). Set any FOV from 1 to 179.

## Controls (changeable in Options > Controls > "FOV Limit Breaker")
- `]`  Increase FOV
- `[`  Decrease FOV
- `\`  Reset FOV to 70
- Toggle key (unbound by default)

## Config
`.minecraft/config/fovbreaker-client.toml`
- `enabled`   - turn the mod on/off
- `customFov` - 1..179
- `step`      - change per key press

Sprint, speed potion and spyglass FOV effects are preserved.

## Build
Requires JDK 17.
1. Easiest: download the Forge 1.20.4 MDK (files.minecraftforge.net), copy `gradle/`, `gradlew`, `gradlew.bat`
   into this folder (or run `gradle wrapper --gradle-version 8.1.1` if you have Gradle installed).
2. Run: `./gradlew build`  (Windows: `gradlew.bat build`)
3. Your mod jar: `build/libs/fovbreaker-1.20.4-1.0.0.jar` -> put in `.minecraft/mods`
