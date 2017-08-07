package util;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */

/*
    TODO:
    Diese klasse soll so, wie sie momentan gestaltet ist, erstmal nur dazu dienen, Variablen zu setten, die
    später in eine Settings Datei gepackt werden (wie z.B. Prefix, Game, usw...)
    Also erstmal alles hier rein packen, auch wenn es später durch eine Settings Datei ersetzt wird.
    - zekro
 */

public class Statics {

    public static final String VERSION = "0.1.0-beta";
    public static final String PREFIX = ".";
    public static final OnlineStatus STATUS = OnlineStatus.ONLINE;


    public static Game getGame() {
        return Game.of("GwendolynBot | testing version v." + VERSION);
    }

    public static String getToken() {
        String out = null;
        String fileName = "TOKEN.txt";
        try {

            File f = new File(fileName);
            if (!f.exists()) {
                f.createNewFile();
                throw new Exception("Token file does not exist and got created");
            }

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            out = br.readLine();
            br.close();
            if (out.length() < 59)
                throw new Exception("Invalid token length");

        } catch (Exception e) {
            System.out.println("[FATAL] Please enter a valid token in the TOKEN.txt file!\n-------------------------------------------------");
            e.printStackTrace();
            System.exit(1);
        }
        return out;
    }

}