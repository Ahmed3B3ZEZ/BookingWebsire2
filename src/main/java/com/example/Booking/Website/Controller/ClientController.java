package com.example.Booking.Website.Controller;

import com.example.Booking.Website.Models.BookReservation;
import com.example.Booking.Website.Models.Client;
import com.example.Booking.Website.Service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("SignupClient")
    public String AddClient(@RequestBody @Valid Client clientObject) {
        return clientService.addClient(clientObject);
    }

    @GetMapping("SearchBook")
    public BookReservation findBook(@RequestParam @Valid Integer id) {
        return clientService.findBook(id);
    }

    @PostMapping("ReserveBook")
    public BookReservation reserveBook(@RequestBody @Valid BookReservation bookReservation) {
        return clientService.reserveBook(bookReservation);
    }

    @DeleteMapping("/{id}/DeleteClient")
    public String deleteClient(@PathVariable @Valid int id) {
        return clientService.deleteClient(id);
    }
}
