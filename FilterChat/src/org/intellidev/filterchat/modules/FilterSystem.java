package org.intellidev.filterchat.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.intellidev.filterchat.file.FilterFile;

public class FilterSystem {

	private Player player;
	private String message;
	public static boolean isBlocked;
	public static List<String> blockedwords = new ArrayList<String>();
	
	
	public FilterSystem(Player player, String message)
	{
		this.player = player;
		this.message = message;
	
		scanPlayer(player, message);
		
	}
	
	public void scanPlayer(Player player, String message) {
		
		if(blockedwords == null) {
			return;
		}
		
		for(String words : blockedwords) {
			if(message.contains(words) || message.contains(words.toString().toUpperCase()) || message.contains(words.toString().toLowerCase())) {
				player.sendMessage(ChatUtils.setFormat(FilterFile.getResponse()));
				isBlocked = true;

				return;
			}
			
				isBlocked = false;
			
		}
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public static boolean getState() {
		return isBlocked;
	}
	
	public static List<String> getBlockedWords() {
		return blockedwords;
	}
	
	public static void blockWord(CommandSender sender, String word) {
		
		if(blockedwords.contains(word)) {
			sender.sendMessage(ChatUtils.setFormat("&cThis word is already blocked."));
			return;
		}
		
		blockedwords.add(word);
		FilterFile.saveWords();
		sender.sendMessage(ChatUtils.setFormat("&eThe word: &f" + word + "&e has been blocked."));
		
	}
	
	public static void removeWord(CommandSender sender, String word) {
		
		if(!(blockedwords.contains(word))) {
			sender.sendMessage(ChatUtils.setFormat("&cThis word is not blocked."));
			return;
		}
		
		blockedwords.remove(word);
		FilterFile.saveWords();
		sender.sendMessage(ChatUtils.setFormat("&eThe word: &f" + word + "&e has been removed from the filter list."));
		
	}

	
}
