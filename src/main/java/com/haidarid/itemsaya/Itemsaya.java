package com.haidarid.itemsaya;

import com.haidarid.itemsaya.command.Cmd;
import com.haidarid.itemsaya.listener.SpellReader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Itemsaya extends JavaPlugin {

	private static Itemsaya Instance;
	private ItemManager ItemManager;


	@Override
	public void onEnable() {
		try {
			Instance = this;
			ItemManager = new ItemManager();
			ItemManager.registerItems();
			Bukkit.getPluginManager().registerEvents(new SpellReader(), this);
			getCommand("itemsaya").setExecutor(new Cmd());
			getConfig().options().copyDefaults();
			saveDefaultConfig();
		} catch (Exception exc) {

		}
	}

	@Override
	public void onDisable() {
	}

	public static Itemsaya getInstance() {
		return Instance;
	}
}
