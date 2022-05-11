package com.example.hotel.hotel.controller;

import com.example.hotel.hotel.Hotel;
import com.example.hotel.hotel.Room;
import com.example.hotel.hotel.RoomDTO;
import com.example.hotel.hotel.repository.HotelRepository;
import com.example.hotel.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;
    @PostMapping
    public String addData(@RequestBody RoomDTO roomDTO){

        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDTO.getHotelId());
        if (!optionalHotel.isPresent()){
            return "Bunday mexmonxona mavjud emas";
        }
        Room xona = new Room();
        xona.setXonaRaqami(roomDTO.getXonaRaqami());
        xona.setQavati(roomDTO.getQavat());
        xona.setXonalarSoni(roomDTO.getXonaSoni());
        xona.setHotel(optionalHotel.get());


        if (roomRepository.existsByXonaRaqamiAndHotelId(roomDTO.getXonaRaqami(), roomDTO.getHotelId())){
            return "Bunday Xona Mavjud";
        }
        roomRepository.save(xona);
        return "Malumotlar Joylandi";
    }
    @PutMapping(value = "/{id}")
    public String update(@PathVariable Integer id,@RequestBody RoomDTO roomDTO){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setQavati(roomDTO.getQavat());
            room.setXonalarSoni(roomDTO.getXonaSoni());
            room.setQavati(roomDTO.getQavat());
            room.setHotel(optionalRoom.get().getHotel());
            return "Malumotlar Tahrirlandi";
        }
        return "Malumot Topilmadi";
    }
}
