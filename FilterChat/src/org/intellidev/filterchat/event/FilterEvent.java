package org.intellidev.filterchat.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.intellidev.filterchat.modules.FilterSystem;

public class FilterEvent implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		String message = e.getMessage();
		
		if(!(player.hasPermission("filterchat.bypass"))) {
		new FilterSystem(player, message);
		
		if(FilterSystem.isBlocked) {
			e.setCancelled(true);
		}
		}
	
	}

}
