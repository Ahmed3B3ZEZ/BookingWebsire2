package com.example.Booking.Website.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor //library Lombok
@NoArgsConstructor //library Lombok
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoCrement
    @Column(name = "user_id")
    private int ClientId;

    @NotNull(message = "Please, Enter Valid Name for you")
    @NotBlank(message = "ClientName is required")
    @Column(name = "user_name")
    private String ClientName;

    @NotNull(message = "Your Password is not Correct")
    @NotBlank(message = "ClientPassword     is required")
    @Column(name = "user_password")
    private String ClientPassword;

    @Email
    @NotNull(message = "Your Email is not Correct")
    @NotBlank(message = "ClientEmail  is required")
    @Column(name = "user_email")
    private String ClientEmail;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<BookReservation> reservations;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
