package ru.bussy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.bussy.Main;
import ru.bussy.utils;

import java.util.Arrays;
import java.util.List;

public class Try implements CommandExecutor {
    private Main plugin;

    public Try(Main main) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if(args.length == 0) {
            return false;
        }
        String text = String.join(" ", (CharSequence[])args);
        if(text.length() > 100) {
            sender.sendMessage(ChatColor.RED + "Ваше сообщение слишком длинное");
            return true;
        }
        String[] TrueOrFalse = {ChatColor.GREEN + "[Успешно]", ChatColor.RED + "[Неуспешно]"};
        String result = utils.getRandom(TrueOrFalse);

        List<Player> PlayersInRadius = utils.setDistance(sender, 150);
        String nameSender = sender.getName();
        String ifHaveRadius = ChatColor.BLUE + "*";

        for(Player PlayerEntity : PlayersInRadius) {
            PlayerEntity.sendMessage(ifHaveRadius + ChatColor.WHITE + " " + nameSender + " " + text + " " + result + " " + ifHaveRadius);
        }

        return true;
    }
}
