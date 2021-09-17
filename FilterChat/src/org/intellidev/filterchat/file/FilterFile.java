package org.intellidev.filterchat.file;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.intellidev.filterchat.FilterChat;
import org.intellidev.filterchat.modules.FilterSystem;

public class FilterFile {
	
	
	public static FilterChat fc = FilterChat.getPlugin(FilterChat.class);
	
	public static void setupFiles() {
		
		File blockedwords = new File(fc.getDataFolder(), "blocked-words.yml");
		File messages = new File(fc.getDataFolder(), "messages.yml");
		
		
		//creation of the blocked-words file
		if(!(blockedwords.exists()))
		{
			try {
				blockedwords.createNewFile();
			} catch(Exception ex) {}
		}
		
		//creation of the messages file
		if(!(messages.exists())) 
		{
			try {
				messages.createNewFile();
				YamlConfiguration messagesconfig = YamlConfiguration.loadConfiguration(messages);
				messagesconfig.set("response", "&cYour message contains a forbidden word.");
				
				//saving first value
				messagesconfig.save(messages);
				} catch(Exception ex) {}
		}
		
		YamlConfiguration bwconfig = YamlConfiguration.loadConfiguration(blockedwords);

		for(String words : bwconfig.getStringList("blocked-words")) {
			FilterSystem.blockedwords.add(words);
		}	
	}
	
	public static String getResponse() {
		
		File file = new File(fc.getDataFolder(), "messages.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		return config.getString("response");
		
	}
	
	public static void saveWords() {
		
		File file = new File(fc.getDataFolder(), "blocked-words.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("blocked-words", FilterSystem.getBlockedWords());
		try {
			config.save(file);
		}catch(Exception ex) {}
	}
}
