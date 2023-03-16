package com.example.BookMyShowTicket.Dto;

import com.example.BookMyShowTicket.Enum.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ShowSeatResponseDto {

    private String seatNo;
    private SeatType seatType;
    private int price ;
}
