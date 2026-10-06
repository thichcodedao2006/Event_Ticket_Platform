package com.truongpham.event_ticket_platform.repositories;

import com.truongpham.event_ticket_platform.domains.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Page<Event> findByOrganizerId(UUID organizerId, Pageable pageable);
    // khi viet ham co nghia thi Jpa se tu dong tao code dua tren y nghia ten ham

    Optional<Event> findByIdAndOrganizerId (UUID eventId, UUID organizerId);
}
