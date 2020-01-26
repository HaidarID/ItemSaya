package com.haidarid.itemsaya.listene;

import com.haidarid.itemsaya.Item;
import com.haidarid.itemsaya.ItemManager;
import com.haidarid.itemsaya.Itemsaya;
import com.haidarid.itemsaya.Spell;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class SpellReader implements Listener {

	private static HashMap<Player, Spell> Spell1 = new HashMap<>();
	private static HashMap<Player, Spell> Spell2 = new HashMap<>();
	private static HashMap<Player, Spell> Spell3 = new HashMap<>();

	@EventHandler
	public void onSpell(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Item item = ItemManager.getDisplayName(e.getItem().getItemMeta().getDisplayName());
		if (item != null && item.isHasSkill() == true && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_AIR)) && Spell3.get(p) == null) {
				if (Spell1.get(p) == null) {
					clickDetector(p, e.getAction(), Spell1);
					p.sendTitle(" ", ChatColor.YELLOW + Spell1.get(p).toString() + " - ?", 1, 50, 1);
					deleteSpell(p, false);
				} else if (Spell2.get(p) == null) {
					deleteSpell(p, true);
					clickDetector(p, e.getAction(), Spell2);
					p.sendTitle(" ", ChatColor.YELLOW + Spell1.get(p).toString() + " - " + Spell2.get(p).toString() + " - ?", 1, 50, 1);
					deleteSpell(p, false);
				} else if (Spell3.get(p) == null) {
					deleteSpell(p, true);
					clickDetector(p, e.getAction(), Spell3);
					if (executeSkill(p, item) == true) {
						p.sendTitle(" ", ChatColor.GREEN + Spell1.get(p).toString() + " - " + Spell2.get(p).toString() + " - " + Spell3.get(p).toString(), 1, 50, 1);
					} else {
						p.sendTitle(" ", ChatColor.RED + Spell1.get(p).toString() + " - " + Spell2.get(p).toString() + " - " + Spell3.get(p).toString(), 1, 50, 1);
					}
					deleteSpell(p, false);
				}
			}
	}
	
	private void clickDetector(Player p, Action action, HashMap<Player, Spell> spell) {
		if (action.equals(Action.RIGHT_CLICK_AIR)) {
			spell.put(p, Spell.Right);
		} else if (action.equals(Action.LEFT_CLICK_AIR)) {
			spell.put(p, Spell.Left);
		}
	}
	
	private boolean executeSkill (Player p, Item item) {
		return item.onSpellComplete(p, Spell1.get(p), Spell2.get(p), Spell2.get(p));
	}
	
	private void deleteSpell(Player p, boolean cancel) {
		
			new BukkitRunnable() {
	      
	      @Override
	      public void run() {
	      	if (cancel == true) {
						this.cancel();
					} else {
	      	Spell1.put(p, null);
			  	Spell2.put(p, null);
			  	Spell3.put(p, null);
					}
	      }
	      
	  }.runTaskLater(Itemsaya.getInstance(), 50L);
	}
	  
	
}

