package com.example.hotel.hotel.repository;

import com.example.hotel.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    boolean existsByNomi(String nomi);
}
