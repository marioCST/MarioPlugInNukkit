package de.mariocst.commands.Player;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class VanishCommand extends Command {
    private MarioMain plugin;

    public VanishCommand(MarioMain plugin) {
        super("vanish", "Macht dich unsichtbar.", "vanish", new String[]{"v"});
        this.setPermission("mario.vanish");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (sender.hasPermission("mario.vanish") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                float isScaleZero = player.getScale();

                if (isScaleZero == 0) {
                    player.setScale(1);
                    player.setNameTagVisible(true);
                    sender.sendMessage(MarioMain.PREFIX + "Du bist nun nicht mehr unsichtbar!");
                } else {
                    player.setScale(0);
                    player.setNameTagVisible(false);
                    sender.sendMessage(MarioMain.PREFIX + "Du bist nun unsichtbar!");
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            sender.sendMessage("Bitte gib den Befehl InGame ein");
        }
        return false;
    }
}
