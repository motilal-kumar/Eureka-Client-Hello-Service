package com.neosoft.eurekaclienthelloservice.service;

import com.neosoft.eurekaclienthelloservice.entity.Hotel;
import com.neosoft.eurekaclienthelloservice.entity.Rating;
import com.neosoft.eurekaclienthelloservice.entity.User;
import com.neosoft.eurekaclienthelloservice.exception.ResourceNotFoundException;
import com.neosoft.eurekaclienthelloservice.external.service.HotelService;
import com.neosoft.eurekaclienthelloservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements IUserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUserData(User user) {

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
      //  user.setFirst_name(user.getFirst_name());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUserData() {
        return userRepository.findAll();
    }

    //RestTemplate call.
   /* @Override
    public User getUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !" +userId));

     Rating[] ratingOfUsers =   restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
     List<Rating> ratings = Arrays.stream(ratingOfUsers).collect(Collectors.toList());
       // user.setRatings(ratingOfUsers);
       List<Rating> ratingList =  ratings.stream().map(rating -> {

        ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/hotel/"+rating.getHotelId(), Hotel.class);
           Hotel hotel =  forEntity.getBody();
           logger.info("Response Status Code {} : " +forEntity.getStatusCode());
           rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        logger.info("forObject : "+ratingOfUsers);
        return user;
    }*/


    //FeignClient call.
    @Override
    public User getUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !" +userId));

        Rating[] ratingOfUsers =   restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingOfUsers).collect(Collectors.toList());
        // user.setRatings(ratingOfUsers);
        List<Rating> ratingList =  ratings.stream().map(rating -> {

          //  ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel =  hotelService.getHotel(rating.getHotelId());
           // logger.info("Response Status Code {} : " +forEntity.getStatusCode());
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
      //  logger.info("forObject : "+ratingOfUsers);
        return user;
    }

}
