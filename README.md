# FleetSchedulingApplication

Fleet Scheduling Application 🚛⚡

## 📌 Overview

The Fleet Scheduling Application is designed to efficiently allocate charging resources to a fleet of trucks using various scheduling strategies. The goal is to maximize charging efficiency given a limited number of chargers and time availability.

## How to Run the Application

Before running the application, ensure you have the following installed: Java 11 or later (`java -version`), Maven (`mvn -version`), and Spring Boot (`spring --version`). 

To get started, first clone the repository using the following command:  
`git clone https://github.com/amansingh240698/FleetSchedulingApplication.git`  
Then, navigate to the project directory:  
`cd FleetSchedulingApplication`

Now, you can build and run the application with Maven:  
`mvn clean install`  
`mvn spring-boot:run`

By default, the application will load truck and charger data from `src/main/resources/input.txt` and execute scheduling algorithms with the available `timeAvailable`.

If you need to run the application with custom input, open the `input.txt` file and modify the values. The format for trucks is `id,capacity,current charge`, and for chargers, it's `id,charging rate`. You can also change the available time by editing the appropriate field in the `input.txt` file. 

If you wish to run the application with your own custom scheduling algorithm, you can implement a new algorithm by creating a class that implements `BaseSchedulingAlgorithm`. Then, create an enum identifier for your algorithm in the `SchedulingStrategy` enum, and populate the algorithm in the `algorithmMap` inside `ChargingSchedulerService.class`—the key being the ENUM and the value being your algorithm implementation.

This should cover everything you need to get the application up and running, as well as how to customize it to suit your needs.

