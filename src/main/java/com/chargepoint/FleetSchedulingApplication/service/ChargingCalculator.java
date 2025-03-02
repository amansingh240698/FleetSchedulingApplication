package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import org.springframework.stereotype.Service;

/**
 * Calculates charging time based on truck and charger properties
 */
@Service
public class ChargingCalculator {
  public double calculateChargingTime(Truck truck, Charger charger) {
    if (truck == null || charger == null) {
      throw new IllegalArgumentException("Truck and charger cannot be null");
    }
    if (charger.getChargingRate() <= 0) {
      throw new IllegalArgumentException("Charger rate must be positive");
    }
    return truck.getChargeNeeded() / charger.getChargingRate();
  }
}