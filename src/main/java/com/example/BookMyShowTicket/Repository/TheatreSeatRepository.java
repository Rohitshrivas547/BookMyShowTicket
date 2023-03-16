package com.example.BookMyShowTicket.Repository;

import com.example.BookMyShowTicket.Models.TheatreEntity;
import com.example.BookMyShowTicket.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity, Integer> {
    @Query(value = "select rate from theatre_seat_entity where seat_no=:seatNo and theatre_id=:theatreId",nativeQuery = true)
    public int getPrice(String seatNo, int theatreId);
}
