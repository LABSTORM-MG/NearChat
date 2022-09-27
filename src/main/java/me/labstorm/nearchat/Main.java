package me.labstorm.nearchat;

import me.labstorm.nearchat.commands.GlobalCommand;
import me.labstorm.nearchat.commands.NearChatReloadCommand;
import me.labstorm.nearchat.listeners.AsyncPlayerChatEventListener;
import me.labstorm.nearchat.listeners.CraftItemEventListener;
import me.labstorm.nearchat.listeners.PlayerJoinListener;
import me.labstorm.nearchat.utils.Config;
import me.labstorm.nearchat.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Config configObj;
    // TODO: https://bukkit.org/threads/distance-based-chat.498268/
    // FIXME: config explanation of custom texture pack
    // TODO: properly upload to Bukkit
    // TODO: create private github repo readme
    private static Main instance;

    public static YamlConfiguration getConfiguration() {
        return configObj.getConfig();
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        configObj = new Config();
    }

    @Override
    public void onEnable() {
        Utils.createMegaphoneRecipe();

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new AsyncPlayerChatEventListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new CraftItemEventListener(), this);

        this.getCommand("global").setExecutor(new GlobalCommand());
        this.getCommand("nearchatreload").setExecutor(new NearChatReloadCommand());
    }


}
