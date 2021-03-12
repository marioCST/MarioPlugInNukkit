package de.mariocst.commands.WTF;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class ChatSpamCommand extends Command {
    private MarioMain plugin;

    public ChatSpamCommand(MarioMain plugin) {
        super("chatspam", "Bester Command", "chatspam", new String[]{"cs", "cspam"});
        this.setPermission("mario.chatspam");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mario.chatspam") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (player.getName().equals("marioCST")) {
                    for(int i = 0; i <= 100; i++) {
                        MarioMain.getInstance().getServer().broadcastMessage(MarioMain.PREFIX + "CHATSPAM! Jetzige Zahl: " + i + " / 100");
                        try {
                            Thread.sleep(i);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    player.sendMessage(MarioMain.PREFIX + "HA! Dachtest du wirklich, dass du einfach so den Chat zuspammen könntest?");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "§cKeine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            sender.sendMessage("Bitte führe den Befehl InGame aus!");
        }
        return false;
    }
}
