package org.intellidev.filterchat.modules;

import org.bukkit.ChatColor;

public class ChatUtils {

	public static String setFormat(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
}
