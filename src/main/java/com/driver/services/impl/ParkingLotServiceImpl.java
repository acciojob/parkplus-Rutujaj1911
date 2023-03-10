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
        ParkingLot parkingLot=new ParkingLot(name,address);
        return parkingLot;

//        ParkingLot parkingLot=parkingLotRepository1.findByName(name);
//        parkingLot.setAddress(address);
//        parkingLotRepository1.save(parkingLot);
//        return parkingLot;
//        ParkingLot parkingLot=parkingLotRepository1.save(name,address);
//        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
//        Spot spot=new Spot(parkingLotId,numberOfWheels,pricePerHour);
//        spot.setParkingLot(parkingLotRepository1.findById(parkingLotId).get());
//        ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
//        List<Spot> res=parkingLot.getSpotList();
//        res.add(spot);
//        parkingLot.setSpotList(res);
//        spotRepository1.save(spot);
//        parkingLotRepository1.save(parkingLot);
//        return spot;

        Spot spot=spotRepository1.save(parkingLotId,numberOfWheels,pricePerHour);
        return spot;
    }

    @Override
    public void deleteSpot(int spotId) {
         spotRepository1.deleteById(spotId);
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
//        Spot spot=spotRepository1.findById(spotId).get();
//        ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
//
//        parkingLot.getSpotList().remove(spot);
//        spot.setPricePerHour(pricePerHour);
//        parkingLot.getSpotList().add(spot);

        Spot spot=spotRepository1.save(parkingLotId,spotId,pricePerHour);
        return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
