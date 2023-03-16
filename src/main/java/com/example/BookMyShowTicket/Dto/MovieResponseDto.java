package com.example.BookMyShowTicket.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class MovieResponseDto {

    private int id;

    private String name;

    private int duration;

    private Date releaseDate;
}
