package com.chargepoint.FleetSchedulingApplication.repository;

import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * In-memory implementation of TruckRepository
 */
@Repository
@Primary
public class InMemoryTruckRepository implements TruckRepository {
  private final Map<Integer , Truck> trucks = new HashMap<>();

  @Override
  public Collection<Truck> findAll() {
    return Collections.unmodifiableCollection(trucks.values());
  }

  @Override
  public Optional<Truck> findById(Integer id) {
    return Optional.ofNullable(trucks.get(id));
  }

  @Override
  public void save(Truck truck) {
    trucks.put(truck.getId(), truck);
  }

  @Override
  public void delete(Integer id) {
    trucks.remove(id);
  }
}
