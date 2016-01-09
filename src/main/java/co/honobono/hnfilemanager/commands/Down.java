package co.honobono.hnfilemanager.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import co.honobono.hnfilemanager.Util;

public class Down {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		try {
			Util.Download(Move.getFile(sender), args[1]);
		} catch (IOException e) {
			e.printStackTrace();
			sender.sendMessage("ファイルが見つからないか, アクセスできませんでした");
			return true;
		}
		return true;
	}
}
