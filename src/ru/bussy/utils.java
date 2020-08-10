package ru.bussy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class utils {
    public static List<Player> setDistance(CommandSender sender, int distance) {
        Player[] players = (Player[])Bukkit.getOnlinePlayers().toArray((Object[])new Player[0]);
        List<Player> playersInRadius = new ArrayList<Player>();
        int DISTANCE = distance;
        byte b;
        int i;
        Player[] arrayOfPlayer1;
        for (i = (arrayOfPlayer1 = players).length, b = 0; b < i; ) {
            Player entityPlayer = arrayOfPlayer1[b];
            if (((Entity)sender).getLocation().distance(entityPlayer.getLocation()) <= DISTANCE)
                playersInRadius.add(entityPlayer);
            b = (byte)(b + 1);
        }
        return playersInRadius;
    }

    public static String getRandom(String[] successfully) {
        int rnd = (new Random()).nextInt(successfully.length);
        return successfully[rnd];
    }
}

