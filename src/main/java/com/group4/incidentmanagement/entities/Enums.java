package com.group4.incidentmanagement.entities;

public class Enums {
    public static enum Priority {
        Critical,
        High,
        Medium,
        Low
    }

    public static enum Category {
        Software_Issues,
        Hardware_Issues,
        Accessory_Issues,
    }

    public static enum Status {
        New,
        In_Progress,
        Resolved,
        Rejected
    }
}
