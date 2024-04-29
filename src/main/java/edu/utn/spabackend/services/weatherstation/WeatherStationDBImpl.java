package edu.utn.spabackend.services.weatherstation;

import edu.utn.spabackend.domain.WeatherStation;
import edu.utn.spabackend.persistence.entity.WeatherStationEntity;
import edu.utn.spabackend.persistence.repository.WeatherStationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service("DB")
public class WeatherStationDBImpl implements WeatherStationService {
    @Autowired
    WeatherStationRepository weatherStationRepository;


    @Override
    public void insertRecord(WeatherStation ws) {
        WeatherStationEntity entity = ws.toEntity();
        log.info("Inserting record: " + ws.toString());
        weatherStationRepository.save(new WeatherStationEntity(UUID.randomUUID(), entity.getTimestamp(),
                entity.getWindspeed(), entity.getWinddirection(),
                entity.getHumidity(), entity.getRadiation(),
                entity.getTemperature(), entity.getPressure(),
                entity.getLeafmoisture(), entity.getPluviometer(),
                entity.getWeight()));
    }
}
