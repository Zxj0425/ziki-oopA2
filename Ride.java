package com.a2;

import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> queue; // Queue for visitors
    private LinkedList<Visitor> rideHistory; // LinkedList for visitors who took the ride    private int maxRider; // Maximum number of visitors per cycle
    private int maxRider; // Maximum number of visitors per cycle
    private int numOfCycles; // Number of times the ride has been run

    // Default Constructor
    public Ride() {
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized Constructor
    public Ride(String name, int duration, Employee operator) {
        this.rideName = name;
        this.capacity = duration;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 5;
        this.numOfCycles = 0;
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(LinkedList<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Implement RideInterface methods

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.poll();
            System.out.println(visitor.getName() + " removed from the queue for " + rideName);
        } else {
            System.out.println("Queue is empty for " + rideName);
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Queue for " + rideName + ":");
        for (Visitor visitor : queue) {
            System.out.println("- " + visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run the ride: No operator assigned.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("Cannot run the ride: No visitors in the queue.");
            return;
        }

        System.out.println("Running one cycle of the ride...");
        int riders = Math.min(maxRider, queue.size()); // Determine the number of riders for this cycle
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll(); // Remove from queue
            addVisitorToHistory(visitor); // Add to history
        }
        numOfCycles++;
        System.out.println("Ride cycle completed. Number of cycles run: " + numOfCycles);
    }


    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to the ride history of " + rideName);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in the ride history.");
        } else {
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor);
            }
        }
    }


    @Override
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("The ride history is empty. Nothing to sort.");
        } else {
            Collections.sort(rideHistory, new VisitorComparator());
            System.out.println("Ride history sorted successfully.");
        }
    }

    @Override
    public void exportToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(visitor.getName())
                        .add(String.valueOf(visitor.getAge()))
                        .add(visitor.getAddress())
                        .add(visitor.getTicketNumber());
                writer.println(joiner.toString());
            }
            System.out.println("Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    @Override
    public void importFromCSV(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Visitor visitor = new Visitor(data[0], Integer.parseInt(data[1]), data[2], data[3], Boolean.parseBoolean(data[4]));
                addVisitorToHistory(visitor);
            }
            System.out.println("Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }

    /**
     * import ride history from a file
     * @param filename
     */
    @Override
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String address = data[2];
                    String ticketNumber = data[3];
                    boolean hasPaid = Boolean.parseBoolean(data[4]);

                    // Create a Visitor object and add it to the ride history
                    Visitor visitor = new Visitor(name, age, address, ticketNumber, hasPaid);
                    rideHistory.add(visitor);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
            System.out.println("Ride history successfully imported from " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data from file: " + e.getMessage());
        }
    }

    /**
     * Get the number of visitors in the ride history
     * @return
     */
    @Override
    public int getRideHistorySize() {
        return rideHistory.size();
    }



}