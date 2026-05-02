package com.capella.it4527.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capella.it4527.model.BugTicket;
import com.capella.it4527.model.TaskTicket;
import com.capella.it4527.model.Ticket;
import com.capella.it4527.model.TicketRepository;

@RestController
@RequestMapping
public class TicketController {
    
    @Autowired
    private TicketRepository ticketRepository;
    
    @PutMapping("/ticket/put")
    public String putTicket(@RequestBody Ticket ticket) {
        try {
            ticketRepository.save(ticket);
            return ticket.getType() + " ticket saved!";
        } 
        catch (Exception e) {
             e.printStackTrace();
            return "Error saving ticket" + e.getMessage();
        }
    }

    @GetMapping("/ticket/get")
    public Ticket getTicket(@RequestParam int id) {
        try {
            Optional<Ticket> ticket = ticketRepository.findById(id);
            return ticket.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/ticket/delete")
    public String deleteTicket(@RequestParam int id) {
        try {
            ticketRepository.deleteById(id);
            return "Ticket " + id + " deleted!";
        } catch (Exception e) {
            return "Error deleting ticket";
        }
    }

    @GetMapping("/ticket/getbytype")
    public List<Ticket> getTicketByType(@RequestParam String type) {
        return ticketRepository.findByType(type);
    }
}

