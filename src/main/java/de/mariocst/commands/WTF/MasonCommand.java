package de.mariocst.commands.WTF;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class MasonCommand extends Command {
    private MarioMain plugin;

    public MasonCommand(MarioMain plugin) {
        super("mason", "Bester Command 2", "mason");
        this.setPermission("mario.mason");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mario.mason") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                MarioMain.getInstance().getServer().broadcastMessage(MarioMain.PREFIX + "Mason ist der Allerbeste!");
            } else {
                sender.sendMessage(MarioMain.PREFIX + "§cKeine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            MarioMain.getInstance().getServer().broadcastMessage(MarioMain.PREFIX + "Mason ist der Allerbeste!");
        }
        return false;
    }
}
