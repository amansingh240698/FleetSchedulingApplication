package com.chargepoint.FleetSchedulingApplication.service;

import java.util.List;
import java.util.Map;

public interface ChargingScheduleInterface {

  Map<Integer, List<Integer>> getAssignments();

  int getTrucksCharged();

  void printSchedule();

  String getFormattedSchedule();
}
