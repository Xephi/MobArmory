package me.Xephi.MobArmory;

import java.io.File;
import java.util.List;
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
	skeletonWeapon, skeletonHelmet, skeletonChestPlate, skeletonLeggings, skeletonBoots,
	pigzombieWeapon, pigzombieHelmet, pigzombieChestPlate, pigzombieLeggings, pigzombieBoots,
	witherskeletonWeapon, witherskeletonHelmet, witherskeletonChestPlate, witherskeletonLeggings, witherskeletonBoots;
	public static boolean itemCanBeDrop;
	public static List<String> disabledWorlds;
	
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
			pigzombieWeapon = (Integer) config.get("Entity.PigZombie.Weapon");
			pigzombieHelmet = (Integer) config.get("Entity.PigZombie.Helmet");
			pigzombieChestPlate = (Integer) config.get("Entity.PigZombie.Chestplate");
			pigzombieLeggings = (Integer) config.get("Entity.PigZombie.Leggings");
			pigzombieBoots = (Integer) config.get("Entity.PigZombie.Boots");
			witherskeletonHelmet = (Integer) config.get("Entity.WitherSkeleton.Helmet");
			witherskeletonChestPlate = (Integer) config.get("Entity.WitherSkeleton.Chestplate");
			witherskeletonLeggings = (Integer) config.get("Entity.WitherSkeleton.Leggings");
			witherskeletonBoots = (Integer) config.get("Entity.WitherSkeleton.Boots");
			witherskeletonWeapon = (Integer) config.get("Entity.WitherSkeleton.Weapon");
			itemCanBeDrop = config.getBoolean("itemCanBeDrop");
			if (!config.contains("disabledWorlds")) {
				config.set("disabledWorlds", "[]");
				config.getStringList("disabledWorlds").add("put_here_disabled_worlds");
				saveConfig();
			}
			disabledWorlds = config.getStringList("disabledWorlds");
		} catch (NullPointerException ex) {
			
		}
	}
}
