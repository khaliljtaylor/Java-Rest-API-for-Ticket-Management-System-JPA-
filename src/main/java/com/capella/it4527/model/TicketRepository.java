package com.capella.it4527.model;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends ListCrudRepository<Ticket, Integer> {
    List<Ticket> findByType(String type);
}
