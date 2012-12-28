package me.Xephi.MobArmory;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobArmory extends JavaPlugin{
	
	PluginManager pluginmanager;
	public FileConfiguration config;
	public final Logger log = Logger.getLogger("Minecraft");
	public static int zombieWeapon, zombieHelmet, zombieChestPlate, zombieLeggings, zombieBoots, 
	skeletonWeapon, skeletonHelmet, skeletonChestPlate, skeletonLeggings, skeletonBoots;
	public static boolean itemCanBeDrop;
	
	@Override
	public void onDisable() {
		System.out.println("[MobArmory] " +  this.getDescription().getVersion() + " version is disabled");
	}
	
	@Override
	public void onEnable() {
		// Check if all the config file exists
		if(!new File(getDataFolder()+File.separator+"config.yml").exists()){
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
	    
		// Load the config file
		loadConfig();
		
		// Register Event
		pluginmanager  = this.getServer().getPluginManager();
		Listener listener = new MobArmoryListener(this);
		pluginmanager.registerEvents(listener, this);
		
		// Then plugin is enable
		System.out.println("[MobArmory] " + this.getDescription().getVersion() + " version is enabled");
	}
	
	public void loadConfig() {
		config = getConfig();
		try {
			zombieWeapon = (Integer) config.get("Entity.Zombie.Weapon");
			zombieHelmet = (Integer) config.get("Entity.Zombie.Helmet");
			zombieChestPlate = (Integer) config.get("Entity.Zombie.Chestplate");
			zombieLeggings = (Integer) config.get("Entity.Zombie.Leggings");
			zombieBoots = (Integer) config.get("Entity.Zombie.Boots");
			skeletonHelmet = (Integer) config.get("Entity.Skeleton.Helmet");
			skeletonChestPlate = (Integer) config.get("Entity.Skeleton.Chestplate");
			skeletonLeggings = (Integer) config.get("Entity.Skeleton.Leggings");
			skeletonBoots = (Integer) config.get("Entity.Skeleton.Boots");
			skeletonWeapon = (Integer) config.get("Entity.Skeleton.Weapon");
			itemCanBeDrop = config.getBoolean("itemCanBeDrop");
		} catch (NullPointerException ex) {
			
		}
	}
}
