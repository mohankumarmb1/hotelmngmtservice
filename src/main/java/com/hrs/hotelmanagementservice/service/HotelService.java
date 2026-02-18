package com.hrs.hotelmanagementservice.service;


import com.hrs.hotelmanagementservice.exceptions.HotelNotFoundException;
import com.hrs.hotelmanagementservice.model.Hotel;
import com.hrs.hotelmanagementservice.proxy.IHotelService;
import com.hrs.hotelmanagementservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HotelService implements IHotelService
{
    @Autowired
    private HotelRepository hotelRepository;


    public Hotel addHotel(Hotel hotel)
    {
            Hotel newHotel= hotelRepository.save(hotel);
//            Kafka welcome notification
            System.out.println(hotel);
            return newHotel;

    }

    public Hotel getHotel(Long id) throws HotelNotFoundException
    {
        return hotelRepository.findById(id).stream().findAny().orElseThrow(HotelNotFoundException::new);
    }


    public List<Hotel> getAllHotel()
    {
        return hotelRepository.findAll();
    }


    public Hotel updateHotel(Hotel hotel) throws HotelNotFoundException
    {
        if(hotelRepository.existsById(hotel.getId()))
        {
            try
            {
                return hotelRepository.save(hotel);
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else
        {
            throw new HotelNotFoundException("hotel not found");
        }

    }


    public boolean deleteHotel(Long id) throws HotelNotFoundException
    {
        if(hotelRepository.existsById(id))
        {
            try
            {
                hotelRepository.deleteById(id);
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel not found", new HotelNotFoundException("Hotel not found"));
        }

    }
}
