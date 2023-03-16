package com.example.BookMyShowTicket.Repository;

import com.example.BookMyShowTicket.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {

    @Query(value = "select booked from show_seat_entity where show_id=:showId and seat_no=:seatNo",nativeQuery = true)
    public boolean checkAvailable(int showId, String seatNo);

    @Query(value = "select * from show_seat_entity where show_id=:showId and seat_no=:seatNo",nativeQuery = true)
    public ShowSeatEntity getSeatBySeatNo (int showId, String seatNo);

}
