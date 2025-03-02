package com.chargepoint.FleetSchedulingApplication.beans;

import com.chargepoint.FleetSchedulingApplication.service.ChargingCalculator;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ChargingAssignment {
    private  Truck truck;
    private  Charger charger;
    private  double  chargingTime;
    private  double startTime =0.0;

    public ChargingAssignment(Truck truck, Charger charger, ChargingCalculator calculator) {
        this.truck = Objects.requireNonNull(truck, "Truck cannot be null");
        this.charger = Objects.requireNonNull(charger, "Charger cannot be null");
        this.chargingTime =  calculator.calculateChargingTime(truck, charger);;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    public double getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(double chargingTime) {
        this.chargingTime = chargingTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }
}