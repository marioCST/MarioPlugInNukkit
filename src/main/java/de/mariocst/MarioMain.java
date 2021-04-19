package de.mariocst;

import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;
import de.mariocst.commands.Chat.*;
import de.mariocst.commands.Player.*;
import de.mariocst.commands.Server.*;
import de.mariocst.commands.Setter.*;
import de.mariocst.commands.Util.*;
import de.mariocst.commands.World.*;
import de.mariocst.commands.Announcements.*;

import java.util.HashMap;
import java.util.Map;

public class MarioMain extends PluginBase {

    public static MarioMain instance;

    private Map<String, String> lastMessagedPlayers = new HashMap<>();

    public static String PREFIX = "§8[§6marioCST.de§8] §b";

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        register();

        log("marioCST's PlugIn geladen!");
    }

    @Override
    public void onDisable() {
        log("marioCST's PlugIn entladen!");
    }

    public void log(String text) {
        getLogger().info(PREFIX + text);
    }

    private void register() {
        CommandMap commandMap = getServer().getCommandMap();

        // Announcements
        commandMap.register("broadcast5", new Custom(this));
        commandMap.register("announcekick", new Kick(this));
        commandMap.register("announcereload", new Reload(this));
        commandMap.register("announcerestart", new Restart(this));
        commandMap.register("announcestop", new Stop(this));

        // Chat
        commandMap.register("broadcast", new BroadcastCommand(this));
        commandMap.register("chatclear", new ChatClearCommand(this));

        // Player
        commandMap.register("clear", new ClearInventoryCommand(this));
        commandMap.register("die", new DieCommand(this));
        commandMap.register("dumb", new DumbCommand(this));
        commandMap.register("fly", new FlyCommand(this));
        commandMap.register("freezeme", new FreezeMeCommand(this));
        commandMap.register("gm", new GMCommand(this));
        commandMap.register("heal", new HealCommand(this));
        commandMap.register("invsee", new InvseeCommand(this));
        commandMap.register("nick", new NickCommand(this));
        commandMap.register("realname", new RealnameCommand(this));
        commandMap.register("size", new SizeCommand(this));
        commandMap.register("speed", new SpeedCommand(this));
        commandMap.register("unnick", new UnnickCommand(this));

        // Server
        commandMap.register("kickall", new KickAllCommand(this));

        // Setter
        commandMap.register("setlink", new SetLinkCommand(this));

        // Util
        commandMap.register("date", new DateCommand(this));
        commandMap.register("discord", new DiscordCommand(this));
        commandMap.register("lol", new LolCommand(this));
        commandMap.register("reply", new ReplyCommand(this));

        // World
        commandMap.register("day", new DayCommand(this));
        commandMap.register("night", new NightCommand(this));
    }

    public static MarioMain getInstance() {
        return instance;
    }

    public Map<String, String> getLastMessagedPlayers() {
        return lastMessagedPlayers;
    }
}
