package com.haidarid.itemsaya.items;

import com.haidarid.itemsaya.Item;
import com.haidarid.itemsaya.Spell;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class IronSword extends Item {	
	public IronSword() {
         //material, rarity, name, Displayname, damage, Has skill  
		super(Material.IRON_SWORD, 5, "ironsword", "Iron_Sword", 5, true);
	}

	@Override
	public boolean onSpellComplete(Player player, Spell spell1, Spell spell2, Spell spell3) {
		if (spell1 == Spell.Left && spell2 == Spell.Left && spell3 == Spell.Left) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> setLore() {
		
		return null;
	}

}
