package com.haidarid.itemsaya.command;

import com.haidarid.itemsaya.Item;
import com.haidarid.itemsaya.ItemManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
		String[] args)
	{
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("give")) {
					Item item = ItemManager.getName(args[1]);
					if (item != null) {
						item.giveItem(p);
						return true;
					}
					p.sendMessage("nothing !");
				}
			}
		}
		return false;
	}

}
