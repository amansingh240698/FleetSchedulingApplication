Fleet Scheduling Application 🚛⚡
📌 Overview
The Fleet Scheduling Application is designed to efficiently allocate charging resources to a fleet of trucks using various scheduling strategies. The goal is to maximize charging efficiency given a limited number of chargers and time availability.
🚀 How to Run the Application
1️⃣ Prerequisites
Before running the application, ensure you have the following installed:
Java 11 or later (java -version)
Maven (mvn -version)
Spring Boot (spring --version)

2️⃣ Clone the Repository
git clone https://github.com/your-username/FleetSchedulingApplication.git
cd FleetSchedulingApplication
3️⃣ Build & Run the Application
mvn clean install
mvn spring-boot:run
By default, the application will:
Load truck and charger data from src/main/resources/input.txt.
Execute  scheduling algorithms with timeAvailable 

4️⃣ Run with Custom Input
 Please change the values in input.txt file 
    a.for trucks input is id,capacity,current charge
    b.for chargers the input format is id, charging rate
    c.you can change the available time
    d.You can run the application with custom algorithm .You need to implement your own algorithm implementing BaseSchedulingAlgorithm .
       Create a enum identifier for this algorithm in SchedulingStrategy  and populate the algorithm in algorithm map in ChargingSchedulerService.class where key is the ENUM and value is the algorithm layer . 
