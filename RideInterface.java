package com.a2;

public interface RideInterface {
    /**
     * Add a visitor to the queue
     * @param visitor
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Remove a visitor from the queue
     */
    void removeVisitorFromQueue();

    /**
     * Print the queue of waiting visitors
     */
    void printQueue();

    /**
     * Run the ride for one cycle
     */
    void runOneCycle();

    /**
     * Add a visitor to ride history
     * @param visitor
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Check if a visitor is in the ride history
     * @param visitor
     * @return
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Return the number of visitors in ride history
     * @return
     */
    int numberOfVisitors();

    /**
     * Print the ride history
     */
    void printRideHistory();

    void sortRideHistory();

    void exportToCSV(String filename);

    void importFromCSV(String filename);

    void importRideHistory(String filename);

    int getRideHistorySize();
}