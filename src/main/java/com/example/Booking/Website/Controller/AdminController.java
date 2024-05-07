package com.example.Booking.Website.Controller;

import com.example.Booking.Website.Models.Admin;
import com.example.Booking.Website.Models.BookReservation;
import com.example.Booking.Website.Models.BookResponse;
import com.example.Booking.Website.Repository.BookReservationRepository;
import com.example.Booking.Website.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private BookReservationRepository bookReservationRepository;

    @GetMapping("showAdmin")
    public List<Admin> getAdmin() {
        return adminService.getAdmins();
    }

    @CrossOrigin(origins = "http://localhost:63342") // Add this annotation
    @PostMapping("SignupAdmin")
    public Admin AddAdmin(@RequestBody @Valid Admin AdminObject) {
        return adminService.addAdmin(AdminObject);
    }

    @CrossOrigin(origins = "http://localhost:63342") // Add this annotation
    @PutMapping("/{id}/UpdateAdmin")
    public String UpdateAdmin(@PathVariable int id ,@RequestBody @Valid Admin AdminObject) {
        Admin topicObj = new Admin( id,AdminObject.getName() ,AdminObject.getPassword(),AdminObject.getEmail());
        String result = adminService.updateAdmin(topicObj);
        return result;
    }

    @DeleteMapping("/{id}/DeleteAdmin")
    public String deleteAdmin(@PathVariable("id") @Valid int id) {
        return adminService.deleteAdmin(id);
    }

    @GetMapping("/{id}/FindAdmin")
    public Admin findAdmin(@PathVariable("id") @Valid int id) {
         Admin result = adminService.findAdmin(id);
         return result;
    }

//    --------------------------------

    @GetMapping("showBook")
    public List<BookReservation> getBook() {
        return adminService.getBook();
    }

    @PostMapping("AddBook")
    public BookResponse AddBook(@RequestBody  @Valid BookReservation BookObject) {
        return adminService.addBook(BookObject);
    }

// **make showBook & AddBook HTML Pages***
}
