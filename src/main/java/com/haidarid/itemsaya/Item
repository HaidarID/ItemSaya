package com.haidarid.itemsaya;


import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Item {

	private final ItemStack itemStack;
	private final int tingkatan;
	private final ItemMeta meta;
	private final Material material;
	private final String displayname;
	private boolean skill;
	private final String name;
	
	public Item(Material material, 
							int tingkatan,
							String name,
							String displayName,  
							double damage,
							boolean skill) 
	{
		this.tingkatan = tingkatan;
		this.displayname = ChatColor.RESET + displayName;
		this.material = material;
		this.skill = skill;
		this.name = name;

		
		itemStack = new ItemStack(material); 
		meta = itemStack.getItemMeta();
		addFlags();
		setDamage(damage);
		setDisplayname(getDisplay());
		setItemMeta();

	}
	
	public abstract boolean onSpellComplete(Player player, Spell spell1, Spell spell2, Spell spell3);
	public abstract List<String> setLore();

	private void addFlags() {
		getItemMeta().addItemFlags(ItemFlag.values());
		setItemMeta();
	}
	
	private void setDamage(double damage) {
		AttributeModifier modifier = new AttributeModifier
		(UUID.randomUUID(), "generic.attackDamage", damage, Operation.ADD_NUMBER, EquipmentSlot.HAND);
		getItemMeta().addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
	}
	

	
	public void giveItem(Player p) {
		p.getInventory().addItem(itemStack);
		p.updateInventory();
	}
	
	
	public ItemStack getItemStack() {
		return itemStack;
	}
	


	public String getDisplay() {
		return displayname;
	}
	
	public ItemMeta getItemMeta() {
		return meta;
	}
	
	private void setItemMeta() {
		itemStack.setItemMeta(meta);
	}
	
	private void setDisplayname(String display) {
		getItemMeta().setDisplayName(display);
	}
	
	public int getTingkatan() {
		return tingkatan;
	}

	public boolean isHasSkill() {
		return skill;
	}

	public Material getMaterial() {
		return material;
	}

	public String getName() {
		return name;
	}

}
