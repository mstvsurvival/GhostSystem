package de.ghost.ghostsystem;



import com.google.gson.JsonObject;
import de.ghost.ghostsystem.Economy.EconomySystem;
import de.ghost.ghostsystem.Listerners.ConnectionListeners;
import de.ghost.ghostsystem.Sethome.HomeCommand;
import de.ghost.ghostsystem.Sethome.SethomeCommand;
import de.ghost.ghostsystem.WarpSystem.Config;
import de.ghost.ghostsystem.WarpSystem.WarpCommand;
import de.ghost.ghostsystem.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Ghostsystem extends JavaPlugin {
    private static Ghostsystem instance;
    private static Config cfg;
    private URL url;



    ConsoleCommandSender console = Bukkit.getConsoleSender();
    @Override
    public void onEnable() {
        try {
            url = new URL("https://discord.com/api/webhooks/1200902575382331474/75Qnh6X37lWz_GZThpVhTDD0vCHdbqKkko9ksheQA9UP6SGUiupzgO2X_8XSo3xB6Fe6");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        instance = this;
        cfg = new Config("warps.yml", getDataFolder());




        getCommand("meinschwert").setExecutor(new MeinSchwert());
        getCommand("adminitems").setExecutor(new AdminItemsCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("kopf").setExecutor(new KopfCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("ec").setExecutor(new EnderchestCommand());
        getCommand("gm1").setExecutor(new GamemodeCommand());
        getCommand("gm0").setExecutor(new GamemodeSurvivalCommand());
        getCommand("gm3").setExecutor(new GamemodeSpectatorCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("money").setExecutor(new EconomySystem());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("sethome").setExecutor(new SethomeCommand());
        getCommand("support").setExecutor(new SupportCommand());
        getCommand("msg").setExecutor(new MSGCommand());



        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListeners(), this);
    }
    public static String getPrefix(){
        return ChatColor.GRAY + "[" + ChatColor.BLUE + "Ghost" + ChatColor.GRAY + "] ";
    }

    @Override
    public void onDisable() {
    }

    public static Config getCfg() {
        return cfg;
    }



    public static Ghostsystem getInstance() {
        return instance;
    }
    public void sendDiscord(String content) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content","[GhostSystem] " + content);
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream stream = connection.getOutputStream();
            stream.write(jsonObject.toString().getBytes());
            stream.flush();
            stream.close();

            connection.getInputStream().close();
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}


