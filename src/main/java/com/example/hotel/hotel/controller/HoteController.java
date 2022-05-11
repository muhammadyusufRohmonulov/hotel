package com.example.hotel.hotel.controller;

import com.example.hotel.hotel.Hotel;
import com.example.hotel.hotel.Room;
import com.example.hotel.hotel.repository.HotelRepository;
import com.example.hotel.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Hotel")
public class HoteController {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;
    @GetMapping(value = "oqish/{id}")
    public List<Room> view(@PathVariable Integer id){
        List<Room> roomList = roomRepository.findAllByHotelId(id);
        return roomList;
    }
    @PostMapping
    public String addData(@RequestBody Hotel hotel){

        if (hotelRepository.existsByNomi(hotel.getNomi())){
            return "Bunday mehmonhona mavjud";
        }
        Hotel hotel1 = new Hotel();
        hotel1.setNomi(hotel.getNomi());
        hotelRepository.save(hotel1);
        return "Malumot joylandi";
    }
    @PutMapping(value = "/{id}")
    public String update(@RequestBody Hotel hotel,@PathVariable Integer id){
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()){
            Hotel hotel1 = optionalHotel.get();
            hotel1.setNomi(hotel.getNomi());
            hotelRepository.save(hotel1);
            return "Malumotlar Tahrirlandi";
        }
        return "Malumot Topilmadi";
    }
}
