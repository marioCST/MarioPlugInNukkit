package de.mariocst.AntiCheat.Cheat.inventory;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import de.mariocst.AntiCheat.Cheat.Report;
import de.mariocst.MarioMain;

import java.time.Instant;
import java.util.Date;

public class ReportInvalidItemEnchantmentThread extends Report implements Runnable{
    public ReportInvalidItemEnchantmentThread(Player player) {
        super(player);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            if (player.isOnline() && !player.isOp()) {
                for (Item item : player.getInventory().slots.values()) {
                    if (item.hasEnchantments()) {
                        for (Enchantment e : item.getEnchantments()) {
                            if (e.getLevel() >= 2) {
                                player.getInventory().clearAll();
                                String ban = "Invalid Enchantment Level detected! Please contact an Admin for a ban Appeal!";
                                MarioMain.getInstance().getServer().getNameBans().addBan(player.getName(), ban, Date.from(Instant.ofEpochSecond(-1)), "Console");
                                MarioMain.getInstance().getServer().getIPBans().addBan(player.getName(), ban, Date.from(Instant.ofEpochSecond(-1)), "Console");
                                player.kick(ban, false);
                                MarioMain.getInstance().getServer().broadcastMessage("The Player " + player.getName() + " has been banned for an illegal Enchantment! " + e.getName() + " Lv. " + e.getLevel());
                            }
                        }
                    }
                }
            }

            MarioMain.reportPlayer.remove(player.getName());
            MarioMain.reportThread.remove(player.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
