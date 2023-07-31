package com.neosoft.eurekaclienthelloservice;

import com.neosoft.eurekaclienthelloservice.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaClientHelloServiceApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private RatingService ratingService;

  /*  @Test
    void creatingRating(){

        Rating rating = Rating.builder().rating("10").userId("").hotelId("").feedback("This is created using FeignClient").build();

        ResponseEntity<Rating> ratinResponseEntity = ratingService.createRating(rating);
        System.out.println("New Rating Created ...");

    }*/

}
