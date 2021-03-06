package com.example.hotel.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String xonaRaqami;
    @Column(nullable = false)
    private Integer qavati;
    @Column(nullable = false)
    private Integer xonalarSoni;
    @ManyToOne
    Hotel hotel;
}
