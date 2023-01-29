package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot=parkingLotRepository1.findByName(name);
        parkingLot.setAddress(address);
        parkingLotRepository1.save(parkingLot);
        return parkingLot;
//        ParkingLot parkingLot=parkingLotRepository1.save(name,address);
//        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
        ParkingLot parkingLot=parkingLotRepository1.addParkingLot(parkingLotId,numberOfWheels,pricePerHour);
        Spot spot=spotRepository1.findById(parkingLotId).get();
        parkingLot.setSpot(spot);
        List<Spot> spotList=parkingLot.getSpotList();
        if(spotList==null ) spotList=new ArrayList<>();
        spotList.add(spot);
        parkingLot.setSpotList(spotList);
        spotRepository1.save(spot);
        return spot;
//        Spot spot=spotRepository1.save(parkingLotId,numberOfWheels,pricePerHour);
//        return spot;
    }

    @Override
    public void deleteSpot(int spotId) {
         spotRepository1.deleteById(spotId);
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
        Spot spot=spotRepository1.findById(spotId).get();
        ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();

        parkingLot.getSpotList().remove(spot);
        spot.setPricePerHour(pricePerHour);
        parkingLot.getSpotList().add(spot);

        spotRepository1.save(spot);
        return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
