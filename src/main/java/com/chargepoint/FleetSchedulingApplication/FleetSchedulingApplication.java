package com.chargepoint.FleetSchedulingApplication;

import com.chargepoint.FleetSchedulingApplication.controller.FleetSchedulingFileInputController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FleetSchedulingApplication {
		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(FleetSchedulingApplication.class);
			app.setWebApplicationType(WebApplicationType.NONE);
			ApplicationContext context = app.run(args);
			FleetSchedulingFileInputController cliController = context.getBean(
					FleetSchedulingFileInputController.class);
			cliController.runCommandLineInterface(args);
		}
}
