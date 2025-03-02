package com.chargepoint.FleetSchedulingApplication.repository;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * In-memory implementation of ChargerRepository
 */
@Repository
@Primary
public class InMemoryChargerRepository implements ChargerRepository {
  private final Map<Integer, Charger> chargers = new HashMap<>();


  @Override
  public Collection<Charger> findAll() {
    return Collections.unmodifiableCollection(chargers.values());
  }
  @Override
  public Optional<Charger> findById(Integer id) {
    return Optional.ofNullable(chargers.get(id));
  }

  @Override
  public void save(Charger charger) {
    chargers.put(charger.getId(), charger);
  }

  @Override
  public void delete(Integer id) {
    chargers.remove(id);
  }
}
