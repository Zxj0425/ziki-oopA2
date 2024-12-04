package com.a2;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare alphabetically by name
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // If the name is the same, compare by ticket number
        return v1.getTicketNumber().compareTo(v2.getTicketNumber());
    }
}