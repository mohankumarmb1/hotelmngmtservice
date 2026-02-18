package com.hrs.hotelmanagementservice.proxy;



import com.hrs.hotelmanagementservice.exceptions.HotelNotFoundException;
import com.hrs.hotelmanagementservice.model.Hotel;

import java.util.List;

public interface IHotelService
{

    public Hotel addHotel(Hotel hotel);

    public Hotel getHotel(Long id) throws HotelNotFoundException;


    public List<Hotel> getAllHotel();


    public Hotel updateHotel(Hotel hotel) throws HotelNotFoundException;


    public boolean deleteHotel(Long id) throws HotelNotFoundException;

}
