package com.ApiHit.ApiHit.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityServices {
    @Autowired
    private CityRepo repo;

    public City Saved(City city){
         return repo.save(city);
    }

    public List<City> ViewAll(){
        return repo.findAll();
    }

    public City FindByCountry(String country) {
        return repo.findById(country).get();
    }

    public City FindByIso2(String iso2){
        return repo.findByIso2(iso2);
    }

    public City FindByIso3(String iso3){
        return repo.findByIso3(iso3);
    }

    public List<City> FindByCity(String city){
        List<City> ans=new ArrayList<>();
        String b=city.toLowerCase();
        List<City> allData=repo.findAll();
        for(City data:allData){
            for(String dataCity:data.getCities()){
                String a=dataCity.toLowerCase();
                if(a.equals(b)){
                    ans.add(data);
                    break;
                }
            }
        }
        return ans;
    }

    public City Update(City c){
        City curr=repo.findById(c.getCountry()).get();
        curr.setCities(c.getCities());
        curr.setIso2(c.getIso2());
        curr.setIso3(c.getIso3());
        return repo.save(curr);
    }

    public String Delete(String country){
        try{
            repo.deleteById(country);
            return (country+" data is deleted successfully\n");
        }
        catch(Exception e){
            System.out.println(HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
