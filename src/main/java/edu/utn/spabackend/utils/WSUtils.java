package edu.utn.spabackend.utils;

import java.util.HashMap;
import java.util.Map;

public class WSUtils {
    public static final String FRAME = "fr";
    public static final Map<String, String> FRAME_MAP = Map.ofEntries(
            Map.entry("pl", "pluviometer"),
            Map.entry("ws", "windspeed"),
            Map.entry("wd", "winddirection"),
            Map.entry("l", "leafmoisture"),
            Map.entry("h", "humidity"),
            Map.entry("r", "radiation"),
            Map.entry("t", "temperature"),
            Map.entry("pr", "pressure"),
            Map.entry("wh", "weight"),
            Map.entry("etc", "etc"),
            Map.entry("wwh", "wetweight"),
            Map.entry("hc", "httpcode"),
            Map.entry("msg", "message"),
            Map.entry("lv", "level"),
            Map.entry("src", "source")
    );
}
