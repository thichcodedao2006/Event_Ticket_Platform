package com.truongpham.event_ticket_platform.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column (name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column (name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
