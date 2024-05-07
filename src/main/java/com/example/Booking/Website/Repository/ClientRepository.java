package com.example.Booking.Website.Repository;

import com.example.Booking.Website.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    void deleteById(int ClientId);
}
