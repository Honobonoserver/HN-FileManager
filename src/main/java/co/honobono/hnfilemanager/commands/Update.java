package co.honobono.hnfilemanager.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import co.honobono.hnfilemanager.Util;

public class Update {
	static PluginManager pm = Bukkit.getPluginManager();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Plugin pl = null;
		try {
			if (args.length != 3) {
				sender.sendMessage("引数が足りません");
				return true;
			}
			pl = pm.getPlugin(args[0]);
			if (pl == null || !pl.isEnabled()) {
				sender.sendMessage("プラグインが読み込まれていないか、有効になっていません");
				return true;
			}
			pm.disablePlugin(pl);
			File out = new File(pl.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
			Util.Download(out, args[2]);
			pm.enablePlugin(pl);
			sender.sendMessage("更新終了しました plugin:" + pl.getName());
		} catch (Exception e) {
			if (!pl.isEnabled()) pm.enablePlugin(pl);
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
