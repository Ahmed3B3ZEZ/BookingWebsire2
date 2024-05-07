package com.example.Booking.Website.Service;

import com.example.Booking.Website.Models.BookReservation;
import com.example.Booking.Website.Models.Client;
import com.example.Booking.Website.Repository.BookReservationRepository;
import com.example.Booking.Website.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    private BookReservationRepository bookReservationRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public String addClient(Client client) {
        clientRepository.save(client);
        return "Done.Adding Client Succeeded";
    }

    public String deleteClient(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "Done,Delete client";
        } else {
            return "Client is not Existed";
        }
    }

    public String updateClient(Client client) {
        if (client == null) {
            return "Client is not Existed";
        }
        clientRepository.save(client);
        return "Done,Updating ";
    }

    public Client findClient(Integer id) {
        Optional<Client> result = clientRepository.findById(id);
        return result.orElse(null);
    }

    public BookReservation reserveBook(BookReservation lib) {
        bookReservationRepository.save(lib);
        return lib;
    }

    public String deleteBook(Integer id) {
        Optional<BookReservation> result = bookReservationRepository.findById(id);
        if (result.isPresent()) {
            bookReservationRepository.deleteById(id);
            return "Done,Delete  Book";
        } else {
            return "Book is not Existed";
        }
    }

    public String updateBook(BookReservation lib) {
        bookReservationRepository.save(lib);
        return "Done,Updating ";
    }

    public BookReservation findBook(Integer id) {
        Optional<BookReservation> result = bookReservationRepository.findById(id);
        return result.orElse(null);
    }
}
