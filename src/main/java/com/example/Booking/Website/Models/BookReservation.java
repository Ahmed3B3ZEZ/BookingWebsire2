package com.example.Booking.Website.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor //library Lombok
@AllArgsConstructor //library Lombok
@Entity
@Table
public class BookReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// //AutoCrement
    @Column(name = "reservation_id")
    private int reservationId;

    @NotBlank(message = "BookName is required")
    @NotNull(message = "Please, Enter a correct Name")
    @Column(name = "book_name")
    private String Book;

    @NotBlank(message = "BookType is required")
    @NotNull(message = "Please, Enter Valid Noun")
    @Column(name = "book_type")
    private String BookType;




    public BookReservation(int reservationId, String book, String bookType) {
        this.reservationId = reservationId;
        Book = book;
        BookType = bookType;
    }

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



}
