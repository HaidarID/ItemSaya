package com.haidarid.itemsaya;

import com.haidarid.itemsaya.items.IronSword;

import java.util.HashMap;



public class ItemManager {
	
	public static HashMap<String, Item> itemName = new HashMap<>();
	public static HashMap<String, Item> itemDisplayname = new HashMap<>();
	
	public void registerItems() {
		registerItem(new IronSword());
	}
	
	public void registerItem(Item item) {
		itemName.put(item.getName(), item);
		itemDisplayname.put(item.getDisplay(), item);
		setLore(item);
	}
	
	public static Item getName(String name) {
		return itemName.get(name);
	}
	
	public static Item getDisplayName(String name) {
		return itemDisplayname.get(name);
	}
	
	private static void setLore(Item item) {
		item.getItemMeta().setLore(item.setLore());
	}
	
}
