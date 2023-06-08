package com.ApiHit.ApiHit.Controllers;

import com.ApiHit.ApiHit.City.City;
import com.ApiHit.ApiHit.City.CityServices;
import com.ApiHit.ApiHit.City.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityServices services;
    @PostMapping
    public String getCity(){
        String uri="https://countriesnow.space/api/v0.1/countries";
        RestTemplate template=new RestTemplate();
        ResponseEntity<Entries> objects=(template.getForEntity(uri, Entries.class));
        for(City c:objects.getBody().getData()){
            services.Saved(c);
        }
        return "Data saved in MongoDB successfully/n";
    }
    @PostMapping("/add")
    public City Add(@RequestBody City c) {
        return services.Saved(c);
    }
    @GetMapping("/viewdata")
    public List<City> ViewData(){
        return services.ViewAll();
    }

    @GetMapping("/iso2/{iso}")
    public City ViewIso2(@PathVariable String iso){
        return services.FindByIso2(iso);
    }

    @GetMapping("/iso3/{iso}")
    public City ViewIso3(@PathVariable String iso){
        return services.FindByIso3(iso);
    }

    @GetMapping("/country/{c}")
    public City ViewCountry(@PathVariable String c){
        return services.FindByCountry(c);
    }

    @GetMapping("/city/{c}")
    public List<City> ViewCity(@PathVariable String c){
        return services.FindByCity(c);
    }

    @PutMapping()
    public City Update(@PathVariable City c){
        return services.Update(c);
    }

    @DeleteMapping("/{country}")
    public String Delete(@PathVariable String country){
        return services.Delete(country);
    }
}

