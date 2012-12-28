package me.Xephi.MobArmory;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class MobArmoryListener implements Listener {
	
	MobArmory main;
	private static boolean drop = MobArmory.itemCanBeDrop;
	
	public MobArmoryListener(MobArmory main) {
		this.main = main;
	}

	@EventHandler (priority = EventPriority.HIGHEST)
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		if (!(event.getEntity() instanceof Zombie) && !(event.getEntity() instanceof Skeleton)) {
			return;
		}
		
		if (MobArmory.disabledWorlds.contains(event.getEntity().getWorld().getName())) {
			return;
		}
		
		if (event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if (zombie.getType() == EntityType.ZOMBIE) {
				setWeapon(event.getEntity(), new ItemStack(MobArmory.zombieWeapon));
				if (isHelmet(MobArmory.zombieHelmet))
					setHelmet(event.getEntity(), new ItemStack(MobArmory.zombieHelmet));
				if (isChestplate(MobArmory.zombieChestPlate))
					setChestplate(event.getEntity(), new ItemStack(MobArmory.zombieChestPlate));
				if (isLeggings(MobArmory.zombieLeggings))
					setLeggings(event.getEntity(), new ItemStack(MobArmory.zombieLeggings));
				if (isBoots(MobArmory.zombieBoots))
					setBoots(event.getEntity(), new ItemStack(MobArmory.zombieBoots));
			} else {
				setWeapon(event.getEntity(), new ItemStack(MobArmory.pigzombieWeapon));
				if (isHelmet(MobArmory.pigzombieHelmet))
					setHelmet(event.getEntity(), new ItemStack(MobArmory.pigzombieHelmet));
				if (isChestplate(MobArmory.pigzombieChestPlate))
					setChestplate(event.getEntity(), new ItemStack(MobArmory.pigzombieChestPlate));
				if (isLeggings(MobArmory.pigzombieLeggings))
					setLeggings(event.getEntity(), new ItemStack(MobArmory.pigzombieLeggings));
				if (isBoots(MobArmory.pigzombieBoots))
					setBoots(event.getEntity(), new ItemStack(MobArmory.pigzombieBoots));
			}
		}
		
		if (event.getEntity() instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) event.getEntity();
			if (skeleton.getSkeletonType() == SkeletonType.NORMAL) {
				setWeapon(event.getEntity(), new ItemStack(MobArmory.skeletonWeapon));
				if (isHelmet(MobArmory.skeletonHelmet))
					setHelmet(event.getEntity(), new ItemStack(MobArmory.skeletonHelmet));
				if (isChestplate(MobArmory.skeletonChestPlate))
					setChestplate(event.getEntity(), new ItemStack(MobArmory.skeletonChestPlate));
				if (isLeggings(MobArmory.skeletonLeggings))
					setLeggings(event.getEntity(), new ItemStack(MobArmory.skeletonLeggings));
				if (isBoots(MobArmory.skeletonBoots))
					setBoots(event.getEntity(), new ItemStack(MobArmory.skeletonBoots));
			} else {
				setWeapon(event.getEntity(), new ItemStack(MobArmory.witherskeletonWeapon));
				if (isHelmet(MobArmory.witherskeletonHelmet))
					setHelmet(event.getEntity(), new ItemStack(MobArmory.witherskeletonHelmet));
				if (isChestplate(MobArmory.witherskeletonChestPlate))
					setChestplate(event.getEntity(), new ItemStack(MobArmory.witherskeletonChestPlate));
				if (isLeggings(MobArmory.witherskeletonLeggings))
					setLeggings(event.getEntity(), new ItemStack(MobArmory.witherskeletonLeggings));
				if (isBoots(MobArmory.witherskeletonBoots))
					setBoots(event.getEntity(), new ItemStack(MobArmory.witherskeletonBoots));
			}
		}
		
	}

	public static void setWeapon(LivingEntity mob, ItemStack item){
		mob.getEquipment().setItemInHand(item);
		if (!drop)
			mob.getEquipment().setItemInHandDropChance(0);
	}
	
	public static void setHelmet(LivingEntity mob, ItemStack item){
		mob.getEquipment().setHelmet(item);
		if (!drop)
			mob.getEquipment().setHelmetDropChance(0);
	}
	
	public static void setChestplate(LivingEntity mob, ItemStack item){
		mob.getEquipment().setChestplate(item);
		if (!drop)
			mob.getEquipment().setChestplateDropChance(0);
	}
	
	public static void setLeggings(LivingEntity mob, ItemStack item){
		mob.getEquipment().setLeggings(item);
		if (!drop)
			mob.getEquipment().setLeggingsDropChance(0);
	}
	
	public static void setBoots(LivingEntity mob, ItemStack item){
		mob.getEquipment().setBoots(item);
		if (!drop)
			mob.getEquipment().setBootsDropChance(0);
	}

	public boolean isHelmet(int a) {
		if (a == 298 || a == 302 || a == 306 || a == 310 || a == 314)
			return true;
		return false;
	}
	public boolean isChestplate(int a) {
		if (a == 299 || a == 303 || a == 307 || a == 311 || a == 315)
			return true;
		return false;
	}
	public boolean isLeggings(int a) {
		if (a == 300 || a == 304 || a == 308 || a == 312 || a == 316)
			return true;
		return false;
	}
	public boolean isBoots(int a) {
		if (a == 301 || a == 305 || a == 309 || a == 313 || a == 317)
			return true;
		return false;
	}
	
}

