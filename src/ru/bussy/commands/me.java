package ru.bussy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.bussy.Main;
import ru.bussy.utils;

import java.util.List;

public class me implements CommandExecutor {
    private Main plugin;

    public me(Main main) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            return false;
        }
        String text = String.join(" ", (CharSequence[])args);
        if(text.length() > 100) {
            sender.sendMessage(ChatColor.RED + "Ваше сообщение слишком длинное");
            return true;
        }
        String ifHaveRadius = ChatColor.BLUE + "*";
        List<Player> PlayersInRadius = utils.setDistance(sender, 150);
        String senderName = sender.getName();

        for(Player entityPlayer : PlayersInRadius) {
            entityPlayer.sendMessage(ifHaveRadius + ChatColor.WHITE  + " " + senderName + " " + text + " " + ifHaveRadius);
        }
        return true;
    }
}
