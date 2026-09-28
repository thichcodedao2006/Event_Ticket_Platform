package com.truongpham.event_ticket_platform.repositories;

import com.truongpham.event_ticket_platform.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
