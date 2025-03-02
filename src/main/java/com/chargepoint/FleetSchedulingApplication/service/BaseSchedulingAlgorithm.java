package com.chargepoint.FleetSchedulingApplication.service;

import java.util.Objects;

/**
 * Abstract base class for scheduling algorithms with common functionality
 */
abstract class BaseSchedulingAlgorithm implements SchedulingAlgorithm {
  protected final ChargingCalculator calculator;

  protected BaseSchedulingAlgorithm(ChargingCalculator calculator) {
    this.calculator = Objects.requireNonNull(calculator, "Calculator cannot be null");
  }

  @Override
  public String getName() {
    return getClass().getSimpleName().replace("Algorithm", "");
  }
}