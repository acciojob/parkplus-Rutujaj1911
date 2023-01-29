package com.driver.repository;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer>{
//  ParkingLot save(String name, String address);

  ParkingLot findByName(String name);

  ParkingLot addParkingLot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour);
//    ParkingLot findByName(String name);
}
