package com.ApiHit.ApiHit.City;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends MongoRepository<City,String> {

    City findByIso2(String iso2);

    City findByIso3(String iso3);
}
