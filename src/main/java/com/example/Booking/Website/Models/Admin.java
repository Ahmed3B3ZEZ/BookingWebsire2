package com.example.Booking.Website.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor //library Lombok
@AllArgsConstructor //library Lombok
@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoCrement
    @Column(name = "admin_id")
    private int AdminId;

    @NotNull(message = "Please, Enter Valid Name for Admin")//null
    @NotBlank(message = "AdminName is required")
    @Column(name = "admin_name")
    private String name;

    @NotNull
    @NotBlank(message = "AdminPassword is required")
    @Column(name = "admin_password")
    private String password;

    @Email
    @NotNull(message = "Your Email is not Correct")
    @NotBlank(message = "AdminEmail is required")
    @Column(name = "admin_email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<BookReservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Client> clients;

    public Admin(int adminId, String name, String password, String email) {
        AdminId = adminId;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}