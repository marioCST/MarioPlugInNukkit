package de.mariocst.commands.Player;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class FreezeMeCommand extends Command {
    private MarioMain plugin;

    public FreezeMeCommand(MarioMain plugin) {
        super("freezeme", "Lässt dich einfrieren", "freezeme", new String[]{"fm"});
        this.setPermission("mario.freezeme");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("mario.freezeme") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (player.isImmobile()) {
                    player.setImmobile(false);
                    sender.sendMessage(MarioMain.PREFIX + "§aDu kannst dich nun ohne AntiImmobile bewegen!");
                } else if (!player.isImmobile()) {
                    player.setImmobile(true);
                    sender.sendMessage(MarioMain.PREFIX + "§4Du kannst dich nun nur noch mit AntiImmobile bewegen!");
                } else {
                    sender.sendMessage(MarioMain.PREFIX + "ETWAS IST GEWALTIG SCHIEF GELAUFEN! BITTE WENDE DICH AN DEN SUPPORT!");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            sender.sendMessage("Bitte führe den Command InGame aus!");
        }
        return false;
    }
}
