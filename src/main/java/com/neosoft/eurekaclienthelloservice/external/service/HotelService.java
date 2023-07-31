package com.neosoft.eurekaclienthelloservice.external.service;


import com.neosoft.eurekaclienthelloservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);


}
