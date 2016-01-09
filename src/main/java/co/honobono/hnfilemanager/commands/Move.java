package co.honobono.hnfilemanager.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import co.honobono.hnfilemanager.HNFileManager;

public class Move {

	private static Map<CommandSender, File> map = new HashMap<>();

	public static File getFile(CommandSender sender) {
		if(!map.containsKey(sender)) map.put(sender, HNFileManager.getInstance().getDataFolder());
		return (map.get(sender));
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(args.length == 1) {
			sender.sendMessage("引数が足りません");
			return true;
		}
		File f = getFile(sender);
		if(args[1].equalsIgnoreCase("..")) {
			map.put(sender, f.getParentFile());
		} else if(args[1].equalsIgnoreCase("*list")) {
			sender.sendMessage("現在: " + f.toString());
			if(f.isDirectory()) {
				sender.sendMessage(f.list());
			} else {
				sender.sendMessage("ファイルのため表示できません");
			}
		} else {
			map.put(sender, new File(f, args[1]));
		}
		return true;
	}
}
