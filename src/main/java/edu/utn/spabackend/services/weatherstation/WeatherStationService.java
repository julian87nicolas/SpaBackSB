package edu.utn.spabackend.services.weatherstation;

import edu.utn.spabackend.domain.WeatherStation;
import edu.utn.spabackend.utils.WSUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface WeatherStationService {
    public void insertRecord(WeatherStation ws);
    default public WeatherStation parseFrame(String frame) {
        // Trim the frame getting only the content between > and <, and split it by ;
        String[] frameParts = frame.substring(frame.indexOf("+") + 1, frame.indexOf("<")).split(";");
        WeatherStation ws = new WeatherStation();
        //Create a map with the keys and values of the frame
        Map<String, String> frameMap = new HashMap<>();
        Arrays.stream(frameParts).forEach(part -> {
            String[] keyAndValue = part.split(":");
            frameMap.put(WSUtils.FRAME_MAP.get(keyAndValue[0]), keyAndValue[1]);
        });
        //Set the values of the WeatherStation object
        ws.setWindspeed(Integer.parseInt(frameMap.get("windspeed")));
        ws.setWinddirection(Integer.parseInt(frameMap.get("winddirection")));
        ws.setHumidity(Integer.parseInt(frameMap.get("humidity")));
        ws.setRadiation(Integer.parseInt(frameMap.get("radiation")));
        ws.setTemperature(Integer.parseInt(frameMap.get("temperature")));
        ws.setPressure(Integer.parseInt(frameMap.get("pressure")));
        ws.setLeafmoisture(Integer.parseInt(frameMap.get("leafmoisture")));
        ws.setPluviometer(Integer.parseInt(frameMap.get("pluviometer")));
        ws.setWeight(Integer.parseInt(frameMap.get("weight")));

        return ws;
    }
}
