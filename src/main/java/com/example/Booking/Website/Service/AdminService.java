package com.example.Booking.Website.Service;

import com.example.Booking.Website.Models.Admin;
import com.example.Booking.Website.Models.BookReservation;
import com.example.Booking.Website.Models.BookResponse;
import com.example.Booking.Website.Repository.AdminRepository;
import com.example.Booking.Website.Repository.BookReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BookReservationRepository bookReservationRepository;

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin adm) {
        return adminRepository.save(adm);
    }

    public String deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Admin is not Existed";
        }
    }

    public String updateAdmin(Admin adm) {
        adminRepository.save(adm);
        return "Done,Updating ";
    }

    public Admin findAdmin(Integer id) {
        Optional<Admin> result = adminRepository.findById(id);
        return result.orElse(null);
    }

//  --------------------------------

    public List<BookReservation> getBook() {
        return bookReservationRepository.findAll();
    }


    public BookResponse addBook(BookReservation lib) {
        bookReservationRepository.save(lib);
        BookResponse bookResponse = new BookResponse(lib.getReservationId(),lib.getBook(),lib.getBookType());

        return bookResponse;
    }
}
