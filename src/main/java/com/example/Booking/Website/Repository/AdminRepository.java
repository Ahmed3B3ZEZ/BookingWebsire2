package com.example.Booking.Website.Repository;

import com.example.Booking.Website.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findById(int AdminId);
    void deleteById(int AdminId);
}
