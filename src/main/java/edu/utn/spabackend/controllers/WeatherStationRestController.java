package edu.utn.spabackend.controllers;

import edu.utn.spabackend.domain.WeatherStation;
import edu.utn.spabackend.persistence.entity.WeatherStationEntity;
import edu.utn.spabackend.services.weatherstation.WeatherStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import edu.utn.spabackend.utils.WSUtils;

@Slf4j
@RestController
public class WeatherStationRestController {
    @Autowired
    WeatherStationService weatherStationService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertRecord(@RequestBody Map<String, Object> body) {
        String frame = (String) body.get(WSUtils.FRAME);
        log.info("Received frame: " + frame);
        WeatherStation ws = weatherStationService.parseFrame(frame);
        log.info("Parsed frame: " + ws.toString());
        weatherStationService.insertRecord(ws);
        return ResponseEntity.ok().body("Record inserted" + ws.toString());
    }
}
