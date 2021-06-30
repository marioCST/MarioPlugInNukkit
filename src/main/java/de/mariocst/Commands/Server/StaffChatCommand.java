package de.mariocst.Commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class StaffChatCommand extends Command {
    private MarioMain plugin;

    public StaffChatCommand(MarioMain plugin) {
        super("staffchat", "Chat für Teammitglieder!", "staffchat", new String[]{"sc"});
        this.setPermission("mario.staff");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        String message = String.join(" ",  args);

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("mario.staff") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                for (Player staff : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                    if (staff.hasPermission("mario.staff")) {
                        staff.sendMessage("§8[§6StaffChat§8] §7" + player.getName() + " §6" + message.replaceAll("&", "§"));

                        MarioMain.getInstance().getServer().getConsoleSender().sendMessage("§8[§6StaffChat§8] §7" + player.getName() + " §6" + message.replaceAll("&", "§"));
                    }
                }
            } else {
                player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            for (Player staff : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                if (staff.hasPermission("mario.staff")) {
                    staff.sendMessage("§8[§6StaffChat§8] §dKonsole §6" + message.replaceAll("&", "§"));

                    MarioMain.getInstance().getServer().getConsoleSender().sendMessage("§8[§6StaffChat§8] §dKonsole §6" + message.replaceAll("&", "§"));
                }
            }
        }

        return false;
    }
}
