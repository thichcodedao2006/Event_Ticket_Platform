package com.truongpham.event_ticket_platform.domains.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequestDTO {

    @NotBlank(message = "Ticket type name is required.")
    private String name;

    @NotNull (message = "Ticket type price is required.")
    @PositiveOrZero (message = "Price must be greater or equal to 0.")
    private Double price;

    private String description;

    @NotNull (message = "Total ticket available is required.")
    @PositiveOrZero (message = "The number must be greater or equal to 0.")
    private Integer totalAvailable;
}
