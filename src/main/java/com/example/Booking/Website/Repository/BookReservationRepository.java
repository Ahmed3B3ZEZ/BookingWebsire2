package com.example.Booking.Website.Repository;

import com.example.Booking.Website.Models.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookReservationRepository extends JpaRepository <BookReservation,Integer> {
    Optional<BookReservation> findById(int reservationId);
    void deleteById(int reservationId);
}
