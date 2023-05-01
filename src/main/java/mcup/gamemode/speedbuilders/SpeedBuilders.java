package mcup.gamemode.speedbuilders;

import mcup.core.Core;
import mcup.core.StageManager;
import mcup.core.stages.Cutscene;
import mcup.core.stages.Waiting;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public final class SpeedBuilders extends JavaPlugin {

    public Core core;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Speed Builders plugin started!");

        // Core API initialization
        core = (Core)Bukkit.getPluginManager().getPlugin("Core");

        if (core == null)
            this.getLogger().warning("This plugin require Core API plugin to function!");

        core.registerStageManager(
                new StageManager(core, this, new ArrayList<>(Arrays.asList(
                        Waiting.class,
                        Cutscene.class
                )))
        );

        saveDefaultConfig();

        core.stageManager.startSequence();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
