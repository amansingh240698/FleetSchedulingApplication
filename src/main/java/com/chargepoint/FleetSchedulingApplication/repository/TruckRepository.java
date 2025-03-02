package com.chargepoint.FleetSchedulingApplication.repository;

import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * DAO interface for Truck entities
 */
@Repository
public interface TruckRepository {
  Collection<Truck> findAll();
  Optional<Truck> findById(Integer id);
  void save(Truck truck);
  void delete(Integer id);
}