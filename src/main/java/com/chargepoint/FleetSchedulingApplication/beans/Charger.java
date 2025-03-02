package com.chargepoint.FleetSchedulingApplication.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Charger {
  private Integer id;
  private double chargingRate;


  public Charger(Integer id, double chargingRate) {
    this.id = id;
    this.chargingRate = chargingRate;
  }

  public double getChargingRate() {
    return chargingRate;
  }

  public void setChargingRate(double chargingRate) {
    this.chargingRate = chargingRate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
