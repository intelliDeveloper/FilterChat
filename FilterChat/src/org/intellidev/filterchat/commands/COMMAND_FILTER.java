package org.intellidev.filterchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.intellidev.filterchat.modules.ChatUtils;
import org.intellidev.filterchat.modules.FilterSystem;

public class COMMAND_FILTER implements CommandExecutor {

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender.hasPermission("filterchat.filter")) {
			
			if(args.length == 0) {
				sender.sendMessage("");
				sender.sendMessage(ChatUtils.setFormat("&e/filter add <word> &8- &fto add a word to the filter list."));
				sender.sendMessage(ChatUtils.setFormat("&e/filter remove <word> &8- &fto remove a word from the filter list."));
				sender.sendMessage(ChatUtils.setFormat("&e/filter list &8- &fto see all the filtered words."));
				sender.sendMessage("");
				
			}
			
			if(args.length == 1) {
				String input = args[0];
				if(input.equalsIgnoreCase("add")) {
					sender.sendMessage(ChatUtils.setFormat("&cUsage: /filter add <word>"));
				} else if(input.equalsIgnoreCase("remove")) {
					sender.sendMessage(ChatUtils.setFormat("&cUsage: /filter remove <word>"));
				} else if(input.equalsIgnoreCase("list")) {
					
					
					
					if(FilterSystem.getBlockedWords()!= null) {
					sender.sendMessage(ChatUtils.setFormat("&eBlocked words:"));
					sender.sendMessage("" + FilterSystem.getBlockedWords() + "");
					} else {
						sender.sendMessage(ChatUtils.setFormat("&cThere are currently 0 blocked words."));
						return true;
					}
				} else {
					sender.sendMessage(ChatUtils.setFormat("&cInvalid Arguments! Please proceed by typing /filter."));
				}
			}
			if(args.length == 2) {
				String input = args[0];
				String word = args[1];
				if(input.equalsIgnoreCase("add")) {
					FilterSystem.blockWord(sender, word);
				} else if(input.equalsIgnoreCase("remove")) {
					FilterSystem.removeWord(sender, word);
				} else {
					sender.sendMessage(ChatUtils.setFormat("&cInvalid Arguments! Please proceed by typing /filter."));
				}
			}
			
		} else {
			sender.sendMessage(ChatUtils.setFormat("&cYou have no permission to use this command."));
			return true;
		}
		
		
		return false;
	}
	
	

}
