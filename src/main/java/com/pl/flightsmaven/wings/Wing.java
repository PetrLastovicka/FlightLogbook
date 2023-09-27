package com.pl.flightsmaven.wings;

import com.pl.flightsmaven.flights.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "wings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String manufacturer;
    String model;
    String size;
    @Enumerated(EnumType.STRING)
    Category category;
    boolean my;
    LocalDate purchased;
    float initialHours;
    LocalDate nextCheckDate;
    float nextCheckHours;
    float totalHours;
    boolean active;
    @OneToMany(mappedBy = "wing", cascade = CascadeType.ALL)
    List<Flight> flights;
}
