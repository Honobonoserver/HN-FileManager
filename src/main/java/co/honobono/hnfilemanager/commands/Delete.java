package co.honobono.hnfilemanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Delete {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Move.getFile(sender).delete();
		return true;
	}
}
