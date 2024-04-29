package edu.utn.spabackend.persistence.repository;

import edu.utn.spabackend.persistence.entity.WeatherStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherStationRepository extends JpaRepository<WeatherStationEntity, Long> {
}
