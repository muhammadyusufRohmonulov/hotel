package com.example.hotel.hotel.repository;

import com.example.hotel.hotel.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    boolean existsByXonaRaqamiAndHotelId(String nomi,Integer id);
    List<Room> findAllByHotelId(Integer id);
}
