package fr.whitefox.heracore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (cmd.getName().equalsIgnoreCase("heal")) {

            if (!(sender instanceof Player)) return false;
            Player player = (Player) sender;

            if (args.length == 0) {
                player.setHealth(20.0);
                player.sendMessage("§6[§9Hera§6] §aVotre santé vient d'être restaurée !");
            }

            if (args.length > 0) {
                Player target = Bukkit.getServer().getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur n'existe pas ou n'est pas connecté !");
                    return true;
                }
                target.setHealth(20.0);
                target.sendMessage("§6[§9Hera§6] §aVotre santé vient d'être restaurée !");
                player.sendMessage("§6[§9Hera§6] §aVous venez de restaurer la santé de §c" + target.getName() + "§a !");
            }
        }

        return true;
    }
}
