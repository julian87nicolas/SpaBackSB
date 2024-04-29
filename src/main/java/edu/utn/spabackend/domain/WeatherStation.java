package edu.utn.spabackend.domain;

import edu.utn.spabackend.persistence.entity.WeatherStationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherStation {
    private UUID id;
    private Timestamp timestamp;
    private Integer windspeed;
    private Integer winddirection;
    private Integer humidity;
    private Integer radiation;
    private Integer temperature;
    private Integer pressure;
    private Integer leafmoisture;
    private Integer pluviometer;
    private Integer weight;

    public WeatherStationEntity toEntity() {
        return new WeatherStationEntity(this.id, this.timestamp, this.windspeed,
                this.winddirection, this.humidity, this.radiation,
                this.temperature, this.pressure, this.leafmoisture,
                this.pluviometer, this.weight);
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                ", windspeed=" + windspeed +
                ", winddirection=" + winddirection +
                ", humidity=" + humidity +
                ", radiation=" + radiation +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", leafmoisture=" + leafmoisture +
                ", pluviometer=" + pluviometer +
                ", weight=" + weight +
                '}';
    }
}