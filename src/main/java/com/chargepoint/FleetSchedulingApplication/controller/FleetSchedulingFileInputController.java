package com.chargepoint.FleetSchedulingApplication.controller;

import com.chargepoint.FleetSchedulingApplication.service.FleetSchedulingRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FleetSchedulingFileInputController {

  private final FleetSchedulingRunner runner;

  @Autowired
  public FleetSchedulingFileInputController(FleetSchedulingRunner runner) {
    this.runner = runner;
  }

  public void runCommandLineInterface(String[] args) {
    String filePath = "src/main/resources/input.txt";
    if (args.length > 0) {
      filePath = args[0];
    }
    if (!Files.exists(Paths.get(filePath))) {
      throw new RuntimeException("Input file not found: " + filePath);
    }
    runner.runFromFile(filePath);
  }
}
