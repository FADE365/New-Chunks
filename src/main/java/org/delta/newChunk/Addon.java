package org.delta.newChunk;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.delta.newChunk.hud.NcHud;
import org.delta.newChunk.commands.StaidCommand;
import org.delta.newChunk.modules.NewchunksModule;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("New Chunks");
    public static final HudGroup HUD_GROUP = new HudGroup("New Chunks");

    @Override
    public void onInitialize() {
        LOG.info("Initializing New Chunks Addon");

        // Modules
        Modules.get().add(new NewchunksModule());

        // Commands
        Commands.add(new StaidCommand());

        // HUD
        Hud.get().register(NcHud.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "org.delta.newChunk";
    }
}
