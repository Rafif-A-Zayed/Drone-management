package com.drones.repository;

import com.drones.enums.State;
import com.drones.model.Drone;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DroneRepository extends CrudRepository<Drone,String> {

    List<Drone> getDroneByState(State state);

    List<Drone> findByCapacityLessThan(Double capacity);
    @EntityGraph(attributePaths = "medications")
    @Query("SELECT d FROM Drone d")
    List<Drone> findAllWithMedications();
}
