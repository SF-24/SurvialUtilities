package com.xpkitty.survivalutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UtilCommand implements CommandExecutor {
    SurvivalUtils survivalUtils;
    public UtilCommand(SurvivalUtils survivalUtils) {
        this.survivalUtils=survivalUtils;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0) {
            sender.sendMessage(ChatColor.RED + "ERROR! No command arguments");
            sender.sendMessage(ChatColor.RED + "Displaying usage:");
            sender.sendMessage(ChatColor.RED + "/sutils time");
            sender.sendMessage(ChatColor.RED + "/sutils difficulty");
        } else if(args.length==1) {
            if (args[0].equalsIgnoreCase("time")) {
                sender.sendMessage(ChatColor.WHITE + "Server time is: " + ChatColor.AQUA + survivalUtils.getDataManager().getTime());
            } else if (args[0].equalsIgnoreCase("difficulty")) {
                sender.sendMessage(ChatColor.WHITE + "Displaying server time difficulty " + ChatColor.AQUA + survivalUtils.getTimer().getServerDifficulty());
            }
        }


        return false;
    }
}
