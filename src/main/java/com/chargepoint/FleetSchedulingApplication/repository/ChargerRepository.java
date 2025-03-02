package com.chargepoint.FleetSchedulingApplication.repository;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * DAO interface for Charger entities
 */
@Repository
public interface ChargerRepository {
  Collection<Charger> findAll();
  Optional<Charger> findById(Integer id);
  void save(Charger charger);
  void delete(Integer id);

}