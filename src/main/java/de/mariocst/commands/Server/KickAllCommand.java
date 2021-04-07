package de.mariocst.commands.Server;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class KickAllCommand extends Command {
    private MarioMain plugin;

    public KickAllCommand(MarioMain plugin) {
        super("kickall", "Kickt alle Spieler mit einem bestimmten Grund", "kickall", new String[]{"ka"});
        this.setPermission("mario.kickall");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("mario.kickall") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                try {
                    if (args.length == 0) {
                        int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                        if (count == 0 || (sender instanceof Player && count == 1)) {
                            sender.sendMessage(MarioMain.PREFIX + "Kein Spieler ist Online lol");
                            player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                            return false;
                        }
                        else {
                            for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                                if (t != sender) {
                                    t.kick();
                                }
                            }

                            sender.sendMessage(MarioMain.PREFIX + "Alle Spieler gekickt!");
                        }
                    }
                    else if (args.length > 0) {
                        int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                        if (count == 0 || (sender instanceof Player && count == 1)) {
                            sender.sendMessage(MarioMain.PREFIX + "Kein Spieler ist Online lol");
                            player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                            return false;
                        }
                        else {
                            String reason = String.join(" ", args);
                            for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                                if (t != sender) {
                                    t.kick(reason);
                                }
                            }
                            sender.sendMessage(MarioMain.PREFIX + "Alle Spieler mit dem Grund " + reason + " gekickt!");
                        }
                    }
                    else {
                        sender.sendMessage(MarioMain.PREFIX + "Ungültige Parameter Länge!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    sender.sendMessage(MarioMain.PREFIX + "Ungültige Parameter Länge!");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            try {
                if (args.length == 0) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 0) {
                        sender.sendMessage(MarioMain.PREFIX + "Kein Spieler ist Online lol");
                        return false;
                    }
                    else {
                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                            if (t != sender) {
                                t.kick();
                            }
                        }

                        sender.sendMessage(MarioMain.PREFIX + "Alle Spieler gekickt!");
                    }
                }
                else if (args.length > 0) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 0) {
                        sender.sendMessage(MarioMain.PREFIX + "Kein Spieler ist Online lol");
                        return false;
                    }
                    else {
                        String reason = String.join(" ", args);
                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers().values()) {
                            if (t != sender) {
                                t.kick(reason);
                            }
                        }
                        sender.sendMessage(MarioMain.PREFIX + "Alle Spieler mit dem Grund " + reason + " gekickt!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.PREFIX + "Ungültige Parameter Länge!");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.PREFIX + "Ungültige Parameter Länge!");
            }
        }
        return false;
    }
}
