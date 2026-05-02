package com.capella.it4527.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") 
@JsonSubTypes({
    @JsonSubTypes.Type(value = TaskTicket.class, name = "task"), 
    @JsonSubTypes.Type(value = BugTicket.class, name = "bug")
})
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ticket {

    @Id
    private int id;
    private String title;
    private String type;
    private int priority;
    private String status;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return id + "," + title + "," + type + "," + priority + "," + status;
    }
}
