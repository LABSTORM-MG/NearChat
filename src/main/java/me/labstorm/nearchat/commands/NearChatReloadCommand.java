package me.labstorm.nearchat.commands;

import me.labstorm.nearchat.Main;
import me.labstorm.nearchat.utils.Config;
import me.labstorm.nearchat.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NearChatReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Main.configObj = new Config();
        Bukkit.getServer().removeRecipe(Utils.MEGAPHONE_RECIPE);
        Utils.createMegaphoneRecipe();
        commandSender.sendMessage(ChatColor.GREEN + "reload done!");
        return true;
    }

}
