package me.labstorm.nearchat.commands;

import me.labstorm.nearchat.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GlobalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length != 1) {
            commandSender.sendMessage(ChatColor.RED + "Usage: /global <message>");
            return true;
        }

        String senderName;
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            senderName = p.getDisplayName();
        } else {
            senderName = ChatColor.RED + "" + ChatColor.UNDERLINE + "SERVER";
        }
        for (Player receiver : Bukkit.getOnlinePlayers()) {
            receiver.sendMessage(String.format(Utils.getFormat(), senderName, args[0]));

        }
        return true;
    }
}
