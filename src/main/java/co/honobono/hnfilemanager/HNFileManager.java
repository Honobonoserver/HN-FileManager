package co.honobono.hnfilemanager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import co.honobono.hnfilemanager.commands.Delete;
import co.honobono.hnfilemanager.commands.Down;
import co.honobono.hnfilemanager.commands.Move;
import co.honobono.hnfilemanager.commands.Update;

public class HNFileManager extends JavaPlugin{
	private static Plugin instance;

	@Override
	public void onEnable() {
		instance = this;
		instance.saveDefaultConfig();
		getLogger().info("HN-Updaterを起動しました");
		getCommand("file").setExecutor(this);
	}

	@Override
	public void onDisable() {
		getLogger().info("HN-Updaterを終了しました");
	}

	public static Plugin getInstance() {
		return instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
			sender.sendMessage(ChatColor.GREEN + "======" + ChatColor.BLUE + "Command Help" + ChatColor.GREEN + "======");
			sender.sendMessage("file | option");
			sender.sendMessage("       help                - This");
			sender.sendMessage("       move <dir>          - Change the Directory");
			sender.sendMessage("       down <url>          - Add the URLFile");
			sender.sendMessage("       del | rem           - Remove File");
			sender.sendMessage("       plup <plugin> <url> - Plugin Update");
			return true;
		}
		switch(args[0].toUpperCase()) {
		case "DOWN":
			new Down().onCommand(sender, cmd, commandLabel, args);
		case "MOVE":
			new Move().onCommand(sender, cmd, commandLabel, args);
		case "DEL":
		case "REM":
			new Delete().onCommand(sender, cmd, commandLabel, args);
		case "PLUP":
			new Update().onCommand(sender, cmd, commandLabel, args);
		}
		return true;
	}
}
