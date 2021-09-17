package org.intellidev.filterchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.intellidev.filterchat.commands.COMMAND_FILTER;
import org.intellidev.filterchat.event.FilterEvent;
import org.intellidev.filterchat.file.FilterFile;

public class FilterChat extends JavaPlugin {
	
	@Override
	public void onDisable() {

		//saving the words
        FilterFile.saveWords();

	}

	@Override
	public void onEnable() {
		
		regCmds();
		regEvents();
		
		//creating/loading files of the filter system
		FilterFile.setupFiles();
		
	}
	
	public void regCmds() {
		
		//registering the command
		getCommand("filter").setExecutor(new COMMAND_FILTER());
	}
	
	public void regEvents() {
	
		//registering the chat event
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new FilterEvent(), this);
	}
	

	
}
