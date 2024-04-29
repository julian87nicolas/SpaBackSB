package edu.utn.spabackend.persistence.entity;

import edu.utn.spabackend.domain.WeatherStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "weatherstation", schema = "spa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
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

    public WeatherStation toDomain() {
        return new WeatherStation(this.id, this.timestamp, this.windspeed,
                this.winddirection, this.humidity, this.radiation,
                this.temperature, this.pressure, this.leafmoisture,
                this.pluviometer, this.weight);
    }
}
