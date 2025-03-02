package com.chargepoint.FleetSchedulingApplication.utils;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import com.chargepoint.FleetSchedulingApplication.enums.SchedulingStrategy;

import java.io.*;
import java.util.*;

public class FleetSchedulingUtils {

  public static List<Truck> parseTrucksFromFile(String filePath) throws IOException {
    List<Truck> trucks = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean trucksSection = false;
      while ((line = reader.readLine()) != null) {
        if (line.trim().equalsIgnoreCase("Trucks:")) {
          trucksSection = true;
          continue;
        }
        if (trucksSection && line.trim().isEmpty()) {
          break;
        }
        if (trucksSection) {
          String[] parts = line.split(",");
          if (parts.length == 3) {
            int id = Integer.parseInt(parts[0]);
            double battery = Double.parseDouble(parts[1]);
            double chargeRate = Double.parseDouble(parts[2]);
            trucks.add(new Truck(id, chargeRate, battery));
          }
        }
      }
    }
    return trucks;
  }

  public static List<Charger> parseChargersFromFile(String filePath) throws IOException {
    List<Charger> chargers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean chargersSection = false;
      while ((line = reader.readLine()) != null) {
        if (line.trim().equalsIgnoreCase("Chargers:")) {
          chargersSection = true;
          continue;
        }
        if (chargersSection && line.trim().isEmpty()) {
          break;
        }
        if (chargersSection) {
          String[] parts = line.split(",");
          if (parts.length == 2) {
            int id = Integer.parseInt(parts[0]);
            double rate = Double.parseDouble(parts[1]);
            chargers.add(new Charger(id, rate));
          }
        }
      }
    }
    return chargers;
  }

  public static int parseTimeAvailable(String filePath) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("TimeAvailable:")) {
          return Integer.parseInt(line.split(":")[1].trim());
        }
      }
    }
    return 8;
  }

  public static SchedulingStrategy parseStrategy(String filePath) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("Strategy:")) {
          return SchedulingStrategy.valueOf(line.split(":")[1].trim().toUpperCase());
        }
      }
    }
    return SchedulingStrategy.SHORTEST_CHARGING_TIME;
  }
}
