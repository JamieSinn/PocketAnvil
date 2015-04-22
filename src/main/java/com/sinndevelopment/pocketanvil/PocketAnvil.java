package com.sinndevelopment.pocketanvil;

import com.sinndevelopment.pocketanvil.util.Anvil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PocketAnvil extends JavaPlugin
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            Anvil.OpenAnvil(player);
            player.sendMessage(ChatColor.GOLD + "Pocket Anvil Opened");
            return true;
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "You are not a player, please log in.");
            return true;
        }
    }
}
