package de.mariocst.commands.Player;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;
import de.mariocst.MarioMain;

public class SizeCommand extends Command {
    private MarioMain plugin;

    public SizeCommand(MarioMain plugin) {
        super("size", "Lässt dich größer oder kleiner werden", "size", new String[]{"grösse", "scale", "sz"});
        this.setPermission("mario.size");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mario.size") || sender.hasPermission("mario.*") || sender.hasPermission("*") || sender.isOp()) {
                if (args.length == 1) {
                    String str = args[0];
                    String containsZero = "0";
                    boolean contains0 = str.contains(containsZero);
                    String containsOne = "1";
                    boolean contains1 = str.contains(containsOne);
                    String containsTwo = "2";
                    boolean contains2 = str.contains(containsTwo);
                    String containsThree = "3";
                    boolean contains3 = str.contains(containsThree);
                    String containsFour = "4";
                    boolean contains4 = str.contains(containsFour);
                    String containsFive = "5";
                    boolean contains5 = str.contains(containsFive);
                    String containsSix = "6";
                    boolean contains6 = str.contains(containsSix);
                    String containsSeven = "7";
                    boolean contains7 = str.contains(containsSeven);
                    String containsEight = "8";
                    boolean contains8 = str.contains(containsEight);
                    String containsNine = "9";
                    boolean contains9 = str.contains(containsNine);
                    String containsDot = ".";
                    boolean containsDott = str.contains(containsDot);
                    String containsZeroDot = "0.";
                    boolean contains0Dot = str.contains(containsZeroDot);

                    if (contains0 || contains1 || contains2 || contains3 || contains4 || contains5 || contains6 || contains7 || contains8 || contains9 || containsDott || contains0Dot) {
                        float getSize = Float.parseFloat(args[0]);
                        if (getSize >= 72) {
                            sender.sendMessage(MarioMain.PREFIX + "Bitte wähle eine kleinere Größe! Ab 72 laggt Minecraft hart ^^");
                            player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                        } else if (getSize <= -72) {
                            sender.sendMessage(MarioMain.PREFIX + "Bitte wähle eine größere Größe! Ab -72 laggt Minecraft hart ^^");
                            player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                        } else {
                            if (args[0].equals("1")) {
                                sender.sendMessage(MarioMain.PREFIX + "Deine Größe wurde zurückgesetzt!");
                                player.setScale(1);
                            } else {
                                float size = Float.parseFloat(args[0]);
                                sender.sendMessage(MarioMain.PREFIX + "Deine Größe wurde auf " + args[0] + " gesetzt!");
                                player.setScale(size);
                            }
                        }
                    } else {
                        sender.sendMessage(MarioMain.PREFIX + "Bitte gib eine Zahl ein!");
                        player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                    }
                } else if (args.length >= 2) {
                    sender.sendMessage(MarioMain.PREFIX + "Bitte schreibe eine einspaltige Größe!");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                } else {
                    sender.sendMessage(MarioMain.PREFIX + "Bitte schreibe eine Größe!");
                    player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
                player.getLevel().addSound(player.getLocation(), Sound.RANDOM_ANVIL_LAND);
            }
        } else {
            assert false;
            sender.sendMessage("Du bist eine Konsole.");
        }
        return false;
    }
}
