package com.truongpham.event_ticket_platform.repositories;

import com.truongpham.event_ticket_platform.domains.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

}
