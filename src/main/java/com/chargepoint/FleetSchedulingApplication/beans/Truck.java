package com.chargepoint.FleetSchedulingApplication.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Truck  {
  private Integer id;
  private  double batteryCapacity;
  private  double currentCharge;

  public Truck(Integer id,double currentCharge, double batteryCapacity) {
    this.currentCharge = currentCharge;
    this.batteryCapacity = batteryCapacity;
    this.id = id;
  }

  public double getChargeNeeded() {
    return batteryCapacity - currentCharge;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public double getBatteryCapacity() {
    return batteryCapacity;
  }

  public void setBatteryCapacity(double batteryCapacity) {
    this.batteryCapacity = batteryCapacity;
  }

  public double getCurrentCharge() {
    return currentCharge;
  }

  public void setCurrentCharge(double currentCharge) {
    this.currentCharge = currentCharge;
  }
}