package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import java.util.Collection;

/**
 * Interface for scheduling algorithms - Strategy Pattern
 */
interface SchedulingAlgorithm {
  ChargingScheduleInterface createSchedule(Collection<Truck> trucks, Collection<Charger> chargers, int timeAvailable);
  String getName();
}
