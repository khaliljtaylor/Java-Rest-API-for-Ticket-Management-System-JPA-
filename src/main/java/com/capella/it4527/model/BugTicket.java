package com.capella.it4527.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bug")
public class BugTicket extends Ticket {
    private String severity;

    public BugTicket(){
        setType("bug");
    }

    public String getSeverity() { 
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return super.toString() + "," + severity;
    }
}
