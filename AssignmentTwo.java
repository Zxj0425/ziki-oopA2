package com.a2;

public class AssignmentTwo {
    public static void main(String[] args) {
        // main
        Employee employee = new Employee("Bob", 35, "789 Oak Avenue", "E002", "Ticket Agent");
        Visitor v1 = new Visitor("Mike", 28, "123 Maple Street", "T003", true);
        Visitor v2 = new Visitor("Sophia", 24, "321 Birch Road", "T004", false);

        Ride rollerCoaster = new Ride("Roller Coaster", 2, employee);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.printQueue();

        rollerCoaster.runOneCycle();
        rollerCoaster.printRideHistory();
    }

    public void partThree() {
        // Create a ride object
        Employee operator = new Employee("David", 40, "456 Willow Street", "E002", "Ticket Seller");
        Ride rollerCoaster = new Ride("Thunderbolt", 3, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("James", 30, "234 Cedar Road", "T006", true);
        Visitor visitor2 = new Visitor("Isabella", 23, "567 Pinewood Drive", "T007", false);
        Visitor visitor3 = new Visitor("Ethan", 27, "678 Oakwood Lane", "T008", true);
        Visitor visitor4 = new Visitor("Mia", 21, "789 Cherry Hill", "T009", false);
        Visitor visitor5 = new Visitor("Lucas", 29, "890 Maple Street", "T010", true);


        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Remove a visitor from the queue
        rollerCoaster.removeVisitorFromQueue();

        // Print the current queue
        rollerCoaster.printQueue();
    }


    public void partFourA() {
        // Create a Ride object
        Employee operator = new Employee("Jack", 35, "567 Oak Avenue", "E002", "Ticket Collector");
        Ride rollerCoaster = new Ride("Sky Diver", 3, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Michael", 27, "234 Maple Road", "T006", true);
        Visitor visitor2 = new Visitor("Chloe", 23, "678 Birch Lane", "T007", false);
        Visitor visitor3 = new Visitor("Daniel", 29, "789 Cedar Street", "T008", true);
        Visitor visitor4 = new Visitor("Ava", 21, "101 Pinewood Drive", "T009", false);
        Visitor visitor5 = new Visitor("Ella", 32, "202 Willow Street", "T010", true);

        // Add visitors to the ride history
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // Check if a visitor is in the ride history
        rollerCoaster.checkVisitorFromHistory(visitor3); // Should return true
        rollerCoaster.checkVisitorFromHistory(new Visitor("Michael", 30, "404 Elm Lane", "T006", true)); // Should return false

        // Print the number of visitors in the ride history
        System.out.println("Total number of visitors in ride history: " + rollerCoaster.numberOfVisitors());

        // Print all visitors in the ride history
        rollerCoaster.printRideHistory();
    }


    public void partFourB() {
        // Create a Ride object
        Employee operator = new Employee("Bob", 35, "321 Theme Park Lane", "E002", "Ride Operator");
        Ride ferrisWheel = new Ride("Ferris Wheel", 5, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Sophia", 26, "123 Elm Street", "T005", true);
        Visitor visitor2 = new Visitor("Emma", 22, "456 Pine Road", "T002", false);
        Visitor visitor3 = new Visitor("John", 25, "789 Maple Avenue", "T003", true);
        Visitor visitor4 = new Visitor("Olivia", 24, "101 Oak Street", "T004", false);
        Visitor visitor5 = new Visitor("Liam", 28, "202 Birch Lane", "T001", true);

        // Add visitors to the ride history
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);

        // Print the ride history before sorting
        System.out.println("Ride history before sorting:");
        ferrisWheel.printRideHistory();

        // Sort the ride history
        ferrisWheel.sortRideHistory();

        // Print the ride history after sorting
        System.out.println("Ride history after sorting:");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        // Create a Ride object
        Employee operator = new Employee("Alice", 30, "456 Park Lane", "E003", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 10, operator);
        rollerCoaster.setMaxRider(4); // Set maximum riders per cycle

        // Create Visitors and add them to the queue
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "Address" + i, "T00" + i, true);
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Print all visitors in the queue
        System.out.println("Visitors in the queue before running the ride:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print all visitors in the queue after running the ride
        System.out.println("Visitors in the queue after running one cycle:");
        rollerCoaster.printQueue();

        // Print all visitors in the ride history
        System.out.println("Visitors in the ride history:");
        rollerCoaster.printRideHistory();
    }


    public void partSix() {
        Ride ferrisWheel = new Ride("Ferris Wheel", 8, null);

        // Add some visitors to the ride history
        ferrisWheel.addVisitorToHistory(new Visitor("Anna", 25, "Street 1", "T101", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Ben", 28, "Street 2", "T102", true));
        ferrisWheel.addVisitorToHistory(new Visitor("Clara", 22, "Street 3", "T103", true));

        // Export the ride history to a CSV file
        ferrisWheel.exportToCSV("ride_records.csv");

        // Clear the ride history
        ferrisWheel.getRideHistory().clear();

        // Import the ride history back from the CSV file
        ferrisWheel.importFromCSV("ride_records.csv");

        // Print the imported ride history
        System.out.println("Imported ride history:");
        ferrisWheel.printRideHistory();
    }


    public void partSeven() {
        // Create a new Ride
        Employee operator = new Employee("John Doe", 35, "456 Park Lane", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, operator);

        // Import ride history from the file
        String filename = "ride_records.csv";
        rollerCoaster.importRideHistory(filename);

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in the ride history: " + rollerCoaster.getRideHistorySize());

        // Print all visitors in the ride history
        rollerCoaster.printRideHistory();
    }
}