package com.example.BookMyShowTicket.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class TicketResponseDto {

    private int ticketId;
    private String user_name;
    private String Movie_name;

    private String theatre_name;
    private LocalTime show_time;
    private LocalDate show_Date;
    private String alloted_seats ;
    private int amount;
    private Date booked_on;
}
